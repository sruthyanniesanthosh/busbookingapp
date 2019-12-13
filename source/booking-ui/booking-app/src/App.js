import React from 'react';
import { Route, BrowserRouter as Router } from 'react-router-dom'
import Header from './Header'
import Footer from './Footer'
import Home from './Home'
import SignIn from './SignIn'
import SignUp from './SignUp'
import BusList from './BusList'
import User from './User'
import Verify from './Verify'
import ResetPwd from './ResetPwd'
import Profile from './Profile'
import BookSeats from './BookSeats'



function App() {
  return (
    <div>
      <Router>
        <div>
          <Header />
          <Route exact path="/" component={Home} />
          <Route path="/signIn" component={SignIn} />
          <Route path="/signUp" component={SignUp} />
          <Route path="/busList" component={BusList} />
          <Route path="/user" component={User} />
          <Route path="/verify" component={Verify} />
          <Route path="/resetPassword" component={ResetPwd} />
          <Route path="/profile" component={Profile} />
          <Route path="/bookSeats" component={BookSeats} />
          <Footer />
        </div>
      </Router>
    </div>
  );
}

export default App;
