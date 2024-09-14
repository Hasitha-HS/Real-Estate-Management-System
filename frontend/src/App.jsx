import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListMaintenanceComponent from './components/ListMaintenaceComponent'
import MaintenanceComponent from './components/MaintenanceComponent'

function App() {
 

  return (
    <>
     <BrowserRouter>
        <div id="root">
          <HeaderComponent/>
          <div className="main-content">
            <Routes>
              {/* //http://localhost:3000 */}
              <Route path='/' element={<ListMaintenanceComponent/>}></Route>
              {/* //http://localhost:3000/maintenance */}
              <Route path='/maintenance' element={<ListMaintenanceComponent/>}></Route>
              {/* //http://localhost:3000/add-maintenance */}
              <Route path='/add-maintenance' element= {<MaintenanceComponent/>}></Route>
              {/* //http://localhost:3000/edit-maintenance/1 */}
              <Route path='/edit-maintenance/:id' element = {<MaintenanceComponent/>}></Route>
            </Routes>
          </div>
          <FooterComponent />
        </div>
      </BrowserRouter>
    </>
  )
}

export default App
