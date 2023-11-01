import "@nordhealth/css";
import "@nordhealth/components";

const AdminLayout = () => {
  return (
    <nord-layout>
      <nord-navigation slot="nav">
        <nord-button slot="header" expand>
          <nord-avatar slot="start" name="Bath Clinic" variant="square">
            CS
          </nord-avatar>
          Contact Service
        </nord-button>
        <nord-nav-group heading="Workspace">
          <nord-nav-item href="/contacts" active icon="user-multiple">
            Contacts
          </nord-nav-item>
          <nord-nav-item href="/settings" icon="navigation-settings">
            Settings
          </nord-nav-item>
        </nord-nav-group>
        <nord-dropdown expand slot="footer">
          <nord-button slot="toggle" expand>
            <nord-avatar
              slot="start"
              aria-hidden="true"
              name="Jorge Morla"
            ></nord-avatar>
            Jorge Morla
          </nord-button>
          <nord-dropdown-group>
            <nord-dropdown-item href="/profile">View profile</nord-dropdown-item>
          </nord-dropdown-group>
          <nord-dropdown-item href="/logout">
            Sign out
            <nord-icon slot="end" name="interface-logout"></nord-icon>
          </nord-dropdown-item>
        </nord-dropdown>
      </nord-navigation>
      <nord-header slot="header">
        <h1 class="n-typescale-l">Dashboard</h1>
        <nord-button variant="primary" slot="end">
          <nord-icon slot="start" name="interface-add-small"></nord-icon>
          Create new
        </nord-button>
      </nord-header>
      <nord-stack gap="l">
        <nord-card>
          <h2 slot="header">Card heading</h2>
          <nord-banner variant="success">
            Your order has been shipped and will arrive on May 27th.{" "}
            <a href="#">Track order</a>.
          </nord-banner>
        </nord-card>
      </nord-stack>
    </nord-layout>
  );
};

export default AdminLayout;
