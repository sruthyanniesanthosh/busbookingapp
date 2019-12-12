import React from 'react'
import ReactDOM from 'react-dom'
import './index.css'
import { Route, BrowserRouter as Router } from 'react-router-dom'
import App from './App'
import SignIn from './SignIn'
import SignUp from './SignUp'


import * as serviceWorker from './serviceWorker'
import BusList from './BusList'

const routing = (
  <Router>
    <div>
      <Route exact path="/" component={App} />
      <Route path="/signIn" component={SignIn} />
      <Route path="/signUp" component={SignUp} />
      <Route path="/busList" component={BusList} />

    </div>
  </Router>
)
ReactDOM.render(routing, document.getElementById('root'))


serviceWorker.unregister();

