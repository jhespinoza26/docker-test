(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[179],{1401:function(module,__webpack_exports__,__webpack_require__){"use strict";__webpack_require__.r(__webpack_exports__);(function(module){var react__WEBPACK_IMPORTED_MODULE_0__=__webpack_require__(0);var react__WEBPACK_IMPORTED_MODULE_0___default=__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);var react_d3_speedometer__WEBPACK_IMPORTED_MODULE_1__=__webpack_require__(3255);var react_d3_speedometer__WEBPACK_IMPORTED_MODULE_1___default=__webpack_require__.n(react_d3_speedometer__WEBPACK_IMPORTED_MODULE_1__);function _typeof(e){"@babel/helpers - typeof";return _typeof="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},_typeof(e)}(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.enterModule:undefined;e&&e(module)})();function _defineProperty(e,t,r){if(t in e){Object.defineProperty(e,t,{value:r,enumerable:true,configurable:true,writable:true})}else{e[t]=r}return e}function _classCallCheck(e,t){if(!(e instanceof t)){throw new TypeError("Cannot call a class as a function")}}function _defineProperties(e,t){for(var r=0;r<t.length;r++){var n=t[r];n.enumerable=n.enumerable||false;n.configurable=true;if("value"in n)n.writable=true;Object.defineProperty(e,n.key,n)}}function _createClass(e,t,r){if(t)_defineProperties(e.prototype,t);if(r)_defineProperties(e,r);Object.defineProperty(e,"prototype",{writable:false});return e}function _inherits(e,t){if(typeof t!=="function"&&t!==null){throw new TypeError("Super expression must either be null or a function")}Object.defineProperty(e,"prototype",{value:Object.create(t&&t.prototype,{constructor:{value:e,writable:true,configurable:true}}),writable:false});if(t)_setPrototypeOf(e,t)}function _setPrototypeOf(e,t){_setPrototypeOf=Object.setPrototypeOf||function e(t,r){t.__proto__=r;return t};return _setPrototypeOf(e,t)}function _createSuper(e){var t=_isNativeReflectConstruct();return function r(){var n=_getPrototypeOf(e),o;if(t){var a=_getPrototypeOf(this).constructor;o=Reflect.construct(n,arguments,a)}else{o=n.apply(this,arguments)}return _possibleConstructorReturn(this,o)}}function _possibleConstructorReturn(e,t){if(t&&(_typeof(t)==="object"||typeof t==="function")){return t}else if(t!==void 0){throw new TypeError("Derived constructors may only return object or undefined")}return _assertThisInitialized(e)}function _assertThisInitialized(e){if(e===void 0){throw new ReferenceError("this hasn't been initialised - super() hasn't been called")}return e}function _isNativeReflectConstruct(){if(typeof Reflect==="undefined"||!Reflect.construct)return false;if(Reflect.construct.sham)return false;if(typeof Proxy==="function")return true;try{Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],(function(){})));return true}catch(e){return false}}function _getPrototypeOf(e){_getPrototypeOf=Object.setPrototypeOf?Object.getPrototypeOf:function e(t){return t.__proto__||Object.getPrototypeOf(t)};return _getPrototypeOf(e)}var __signature__=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default.signature:function(e){return e};var BandwidthUsageWidget=function(_Component){_inherits(BandwidthUsageWidget,_Component);var _super=_createSuper(BandwidthUsageWidget);function BandwidthUsageWidget(){var e;_classCallCheck(this,BandwidthUsageWidget);for(var t=arguments.length,r=new Array(t),n=0;n<t;n++){r[n]=arguments[n]}e=_super.call.apply(_super,[this].concat(r));e.state={bandwidthUsage:200};return e}_createClass(BandwidthUsageWidget,[{key:"componentDidMount",value:function e(){var t=this;this.timerHandle=setInterval((function(){t.setState({bandwidthUsage:Math.floor(Math.random()*1e3)+1})}),1500)}},{key:"componentWillUnmount",value:function e(){if(this.timerHandle){clearTimeout(this.timerHandle);this.timerHandle=0}}},{key:"render",value:function e(){var t;return react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"card"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(react_d3_speedometer__WEBPACK_IMPORTED_MODULE_1___default.a,(t={value:this.state.bandwidthUsage,startColor:"red",endColor:"green",needleColor:"steelblue",height:200,ringWidth:40},_defineProperty(t,"needleColor","#895DFF"),_defineProperty(t,"currentValueText","Bandwidth Usage: ${value} Kb"),t)))}},{key:"__reactstandin__regenerateByEval",value:function __reactstandin__regenerateByEval(key,code){this[key]=eval(code)}}]);return BandwidthUsageWidget}(react__WEBPACK_IMPORTED_MODULE_0__["Component"]);var _default=BandwidthUsageWidget;__webpack_exports__["default"]=_default;(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default:undefined;if(!e){return}e.register(BandwidthUsageWidget,"BandwidthUsageWidget","D:\\v3\\bloomtech-react\\src\\components\\Widgets\\BandwidthUsage.js");e.register(_default,"default","D:\\v3\\bloomtech-react\\src\\components\\Widgets\\BandwidthUsage.js")})();(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.leaveModule:undefined;e&&e(module)})()}).call(this,__webpack_require__(7)(module))}}]);