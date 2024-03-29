/**
 * Signin Bloomtech
 */

import React, { Component } from 'react';
import { connect } from 'react-redux';
import Button from '@material-ui/core/Button';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import { Link } from 'react-router-dom';
import { Form, FormGroup, Input } from 'reactstrap';
import LinearProgress from '@material-ui/core/LinearProgress';
import QueueAnim from 'rc-queue-anim';

import authToken from '../Auth/utils/authToken';

if(localStorage.getItem('token')){
    authToken(localStorage.getItem('token'));
}

// components
import {
   SessionSlider
} from 'Components/Widgets';

// app config
import AppConfig from 'Constants/AppConfig';

// redux action
import {
   signinUserInFirebase,
   signinUserInBloomtech,
   signinUserWithFacebook,
   signinUserWithGoogle,
   signinUserWithGithub,
   signinUserWithTwitter
} from 'Actions';

//Auth File
import Auth from '../Auth/Auth';
import { Fab } from '@material-ui/core';

const auth = new Auth();

class Signin extends Component {

   state = {
      user: '',
      password: ''
   }

	/**
	 * On User Login*/
	 
   onUserLogin() {
      if (this.state.user !== '' && this.state.password !== '') {
         this.props.signinUserInBloomtech(this.state, this.props.history);
      }
   }

	/**
	 * On User Sign Up
	 */
   onUserSignUp() {
      this.props.history.push('/signupbloomtech');
   }

   onUserSponsor(){
      this.props.history.push('/registersponsor');
   }

   onNotPassword(){
      this.props.history.push('/notpassword');
   }


   //Auth0 Login
   loginAuth0() {
      auth.login();
   }

   render() {
      const { user, password } = this.state;
      const { loading } = this.props;
      return (
         <QueueAnim type="bottom" duration={2000}>
            <div className="rct-session-wrapper">
               {loading &&
                  <LinearProgress />
               }
               <AppBar position="static" className="session-header">
                  <Toolbar>
                     <div className="container">
                        <div className="d-flex justify-content-between">
                           <div className="session-logo">
                              <Link to="/">
                                 <img src={AppConfig.appLogo} alt="session-logo" className="img-fluid" width="110" height="35" />
                              </Link>
                           </div>
                           {/* <div>
                              <a className="mr-15" onClick={() => this.onUserSponsor}></a>
                              <Button variant="contained" className="btn-light" onClick={() => this.onUserSponsor()}></Button>
                           </div> */}
                           <div>
                              <a className="mr-15" onClick={() => this.onUserSignUp()}>Create New account?</a>
                              <Button variant="contained" className="btn-light" onClick={() => this.onUserSignUp()}>Sign Up</Button>
                           </div>
                        </div>
                     </div>
                  </Toolbar>
               </AppBar>
               <div className="session-inner-wrapper">
                  <div className="container">
                     <div className="row row-eq-height">
                        <div className="col-sm-7 col-md-7 col-lg-8">
                           <div className="session-body text-center">
                              <div className="session-head mb-30">
                                 <h2 className="font-weight-bold">Bienvenido a Bloomtech</h2>
                                 <p className="mb-0"></p>
                              </div>
                              <Form>
                                 <FormGroup className="has-wrapper">
                                    <Input
                                       type="text"
                                       value={user}
                                       name="user"
                                       id="user"
                                       className="has-input input-lg"
                                       placeholder="Enter Email Address or username"
                                       onChange={(event) => this.setState({ user: event.target.value })}
                                    />
                                    <span className="has-icon"><i className="ti-email"></i></span>
                                 </FormGroup>
                                 <FormGroup className="has-wrapper">
                                    <Input
                                       value={password}
                                       type="Password"
                                       name="password"
                                       id="password"
                                       className="has-input input-lg"
                                       placeholder="Password"
                                       onChange={(event) => this.setState({ password: event.target.value })}
                                    />
                                    <span className="has-icon"><i className="ti-lock"></i></span>
                                 </FormGroup>
                                 <FormGroup className="mb-15">
                                    <Button
                                       color="primary"
                                       className="btn-block text-white w-100"
                                       variant="contained"
                                       size="large"
                                       onClick={() => this.onUserLogin()}
                                    >
                                       Sign In
                            			</Button>
                                 </FormGroup>
                 
                              </Form>
                           
                              <p className="mb-0"><a target="_blank" onClick={() => this.onNotPassword()} className="text-muted">Olvidaste tu Contraseña?</a></p>
                              <p className="mb-0"><a target="_blank" href="#/terms-condition" className="text-muted">Terms of Service</a></p>
                           </div>
                        </div>
                        <div className="col-sm-5 col-md-5 col-lg-4">
                           <SessionSlider />
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </QueueAnim>
      );
   }
}

// map state to props
const mapStateToProps = ({ authUser }) => {
   const { user, loading } = authUser;
   return { user, loading }
}

export default connect(mapStateToProps, {
   signinUserInFirebase,
   signinUserInBloomtech,
   signinUserWithFacebook,
   signinUserWithGoogle,
   signinUserWithGithub,
   signinUserWithTwitter
})(Signin);
