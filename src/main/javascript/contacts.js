import "@nordhealth/css";
import { createRoot } from 'react-dom/client';
import AdminLayout from "./components/AdminLayout";
import './contacts.css';

const root = createRoot(document.getElementById('root'));

root.render(<AdminLayout />);