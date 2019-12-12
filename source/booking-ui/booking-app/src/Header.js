import React,{Component} from 'react';
import {NavLink} from 'react-router-dom';
import './Header.css'

class Header extends Component{
  render(){
    return (
    <header>
      <NavLink to="/signIn">Sign In</NavLink> 
      <NavLink to="/signUp">Sign Up</NavLink> 
    </header>
    )
  }
}

export default Header