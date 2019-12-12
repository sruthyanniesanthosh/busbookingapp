import React,{Component} from 'react';
import {Link} from "react-router-dom"

import './App.css'
class Footer extends Component{
  render(){
    return (
    <div>
      
       <Link to="/signIn" activeclassname="active">Sign Out</Link>
  
      
    </div>
    )
  }
}

export default Footer