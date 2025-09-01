import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
//import Arobj  from './Components/Arobj'
//import Renobj from './Components/Renobj'
//import UserStatus  from './Components/UserStatus'
//import UserDashboard from './Components/UserDashboard'
//import Button from './Components/Button'
//import Counter from './Components/Counter'
//import InputForm from './Components/InputForm'
import MultiInputForm  from './Components/MultiInputForm'



ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
 {/*<App />
 <Arobj />
 <Renobj />
 <UserStatus />
 <UserDashboard user="admin"/>
 <Button />
 <Counter />
 <InputForm />*/}
 <MultiInputForm />
  </React.StrictMode>,
)
