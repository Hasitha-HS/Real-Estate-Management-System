import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'

import ListTransactionComponent from './components/ListTransactionComponent'
import TransactionComponent from './components/TransactionComponent'

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

              
//               <Route path='/' element={<ListTransactionComponent />}></Route> {/* //http://localhost:3000 */}
             
              <Route path='/transactions' element={<ListTransactionComponent/>}></Route>  {/* //http://localhost:3000/transactions */}
             
              <Route path='/add-transaction' element= {<TransactionComponent/>}></Route>  {/* //http://localhost:3000/add-transaction */}
            
              <Route path='/edit-transaction/:id' element = {<TransactionComponent/>}></Route>   {/* //http://localhost:3000/edit-transaction/1 */}

//               {/* //http://localhost:3000 */}
//               <Route path='/' element={<ListTenantComponent />}></Route>
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
