import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Navbar from './Navbar';
import Home from './Home'; 
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import AddUser from './users/AddUser';
import EditUser from './users/EditUser';
import ViewUser from './users/ViewUser';

function App() {

  
  return (
    <div className="App">
      <Router>
        <Navbar/>
        <Routes>
          <Route exact path='/' element={<Home/>}/>
          <Route exact path='/adduser' element={<AddUser/>}/>
          <Route exact path='/edituser/user/:id' element={<EditUser/>}/>
          <Route exact path='/viewuser/user/:id' element={<ViewUser/>}/>
        </Routes>
      </Router>
    </div> 
  );
}

export default App;
