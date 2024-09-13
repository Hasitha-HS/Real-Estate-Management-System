import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListTenantComponent from './components/ListTenantComponent'
import TenantComponent from './components/TenantComponent'

function App() {
 

  return (
    <>
     <BrowserRouter>
        <div id="root">
          <HeaderComponent/>
          <div className="main-content">
            <Routes>
              
              <Route path='/' element={<ListTenantComponent />}></Route> {/* //http://localhost:3000 */}
             
              <Route path='/tenants' element={<ListTenantComponent/>}></Route>  {/* //http://localhost:3000/tenants */}
             
              <Route path='/add-transaction' element= {<TenantComponent/>}></Route>  {/* //http://localhost:3000/add-tenant */}
            
              <Route path='/edit-tenant/:id' element = {<TenantComponent/>}></Route>   {/* //http://localhost:3000/edit-tenant/1 */}
            </Routes>
          </div>
          <FooterComponent />
        </div>
      </BrowserRouter>
    </>
  )
}

export default App
