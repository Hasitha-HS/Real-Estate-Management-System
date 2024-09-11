import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListTenantComponent from './components/ListMaintanaceComponent'
import TenantComponent from './components/MaintananceComponent'

function App() {
 

  return (
    <>
     <BrowserRouter>
        <div id="root">
          <HeaderComponent/>
          <div className="main-content">
            <Routes>
              {/* //http://localhost:3000 */}
              <Route path='/' element={<ListTenantComponent />}></Route>
              {/* //http://localhost:3000/tenants */}
              <Route path='/tenants' element={<ListTenantComponent/>}></Route>
              {/* //http://localhost:3000/add-tenant */}
              <Route path='/add-tenant' element= {<TenantComponent/>}></Route>
              {/* //http://localhost:3000/edit-tenant/1 */}
              <Route path='/edit-tenant/:id' element = {<TenantComponent/>}></Route>
            </Routes>
          </div>
          <FooterComponent />
        </div>
      </BrowserRouter>
    </>
  )
}

export default App
