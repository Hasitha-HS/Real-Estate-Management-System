import React from 'react';
import { Link } from 'react-router-dom';

const HeaderComponent = () => {
  return (
    <header>
      <nav className='navbar navbar-expand-lg navbar-dark bg-secondary'>
        <div className="container-fluid">
          <a className="navbar-brand" href="#">Real Estate Management System</a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item">
                <Link className="nav-link" to="/properties">Properties</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link active" to="/tenants">Tenants</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/financial">Financial</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/financial">Maintenance</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/Marketing & Sales">Marketing & Sales</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/financial">Forecasting</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
  );
}

export default HeaderComponent;