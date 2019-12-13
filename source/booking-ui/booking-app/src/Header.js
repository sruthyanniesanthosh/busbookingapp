import React, { Component } from 'react';
import './Header.css'

class Header extends Component {
  render() {
    return (
        <div class="header">
          <a href="/" className="logo">GMJ Travels</a>
          <div class="header-right">
            <a  href="/">Home</a>
            <a href="/signIn">signIn</a>
          </div>
        </div>
    )
  }
}

export default Header