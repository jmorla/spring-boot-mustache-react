const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const TEMPLATE_SUFFIX = "html";

const resolvePath = (pathname) => path.resolve(__dirname, pathname);


const { entries } = require('./src/main/javascript/index');

const isProduction = (mode) => mode === 'production';

const registerEntries = (names) =>
    names.reduce((entries, entry) => ({ ...entries, [entry]: resolvePath(`src/main/javascript/${entry}.js`) }), {});

const registerTemplatesEntries = (templates) =>
    templates.map((name) =>
        new HtmlWebpackPlugin({
            filename: resolvePath(`target/classes/templates/${name}.${TEMPLATE_SUFFIX}`),
            template: resolvePath(`src/main/resources/templates/${name}.${TEMPLATE_SUFFIX}`),
            chunks: ['react', 'nordhealth', name],
        })
    );


const reactConfigRules = {
    test: /\.(js|jsx)$/,
    loader: 'babel-loader',
    options: {
        presets: [
            ['@babel/preset-react',
                {
                    runtime: 'automatic'
                }
            ],
            '@babel/preset-env'
        ]
    }
}

const styleSheetConfigRules = {
    test: /\.css$/,
    use: ['style-loader', 'css-loader']
}

module.exports = (env, args) => {
    const { mode } = args;
    return {
        entry: registerEntries(entries),
        output: {
            path: resolvePath('target/classes/static'),
            publicPath: '/',
            filename: isProduction(mode) ? '[name].[contenthash].js' : '[name].bundle.js'
        },
        resolve: {
            extensions: ['.js', '.jsx']
        },
        plugins: [
            ...registerTemplatesEntries(entries),
        ],
        module: {
            rules: [
                reactConfigRules,
                styleSheetConfigRules
            ]
        },
        optimization: {
            splitChunks: {
                chunks: 'all',
                cacheGroups: {
                    react: {
                        test: /[\\/]node_modules[\\/](react|react-dom)[\\/]/,
                        name: 'react',
                        chunks: 'all',
                    },
                    nordhealth: {
                        test: /[\\/]node_modules[\\/](@nordhealth)[\\/]/,
                        name: 'nordhealth',
                        chunks: 'all'

                    }
                }
            }
        }
    }
}