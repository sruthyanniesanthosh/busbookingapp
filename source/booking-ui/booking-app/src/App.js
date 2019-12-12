import React from 'react';
import './App.css';
import Header from './Header'
import Footer from './Footer'


function App() {
  return (
    <div>
      <Header />
      <div className="jumbotron" >
      <h1>this is a jumbotron</h1>
      </div>
      <Footer />
    </div>
  );
}

export default App;
