(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[130],{1345:function(module,__webpack_exports__,__webpack_require__){"use strict";__webpack_require__.r(__webpack_exports__);(function(module){var react__WEBPACK_IMPORTED_MODULE_0__=__webpack_require__(0);var react__WEBPACK_IMPORTED_MODULE_0___default=__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);var reactstrap__WEBPACK_IMPORTED_MODULE_1__=__webpack_require__(175);var reactstrap__WEBPACK_IMPORTED_MODULE_2__=__webpack_require__(39);var reactstrap__WEBPACK_IMPORTED_MODULE_3__=__webpack_require__(353);var reactstrap__WEBPACK_IMPORTED_MODULE_4__=__webpack_require__(1542);var reactstrap__WEBPACK_IMPORTED_MODULE_5__=__webpack_require__(47);var _material_ui_core_Button__WEBPACK_IMPORTED_MODULE_6__=__webpack_require__(48);var Api__WEBPACK_IMPORTED_MODULE_7__=__webpack_require__(127);var Components_PageTitleBar_PageTitleBar__WEBPACK_IMPORTED_MODULE_8__=__webpack_require__(177);var Util_IntlMessages__WEBPACK_IMPORTED_MODULE_9__=__webpack_require__(13);var Components_RctCollapsibleCard_RctCollapsibleCard__WEBPACK_IMPORTED_MODULE_10__=__webpack_require__(69);var MyApi__WEBPACK_IMPORTED_MODULE_11__=__webpack_require__(182);function _typeof(e){"@babel/helpers - typeof";return _typeof="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},_typeof(e)}(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.enterModule:undefined;e&&e(module)})();function _classCallCheck(e,_){if(!(e instanceof _)){throw new TypeError("Cannot call a class as a function")}}function _defineProperties(e,_){for(var t=0;t<_.length;t++){var r=_[t];r.enumerable=r.enumerable||false;r.configurable=true;if("value"in r)r.writable=true;Object.defineProperty(e,r.key,r)}}function _createClass(e,_,t){if(_)_defineProperties(e.prototype,_);if(t)_defineProperties(e,t);Object.defineProperty(e,"prototype",{writable:false});return e}function _inherits(e,_){if(typeof _!=="function"&&_!==null){throw new TypeError("Super expression must either be null or a function")}Object.defineProperty(e,"prototype",{value:Object.create(_&&_.prototype,{constructor:{value:e,writable:true,configurable:true}}),writable:false});if(_)_setPrototypeOf(e,_)}function _setPrototypeOf(e,_){_setPrototypeOf=Object.setPrototypeOf||function e(_,t){_.__proto__=t;return _};return _setPrototypeOf(e,_)}function _createSuper(e){var _=_isNativeReflectConstruct();return function t(){var r=_getPrototypeOf(e),a;if(_){var o=_getPrototypeOf(this).constructor;a=Reflect.construct(r,arguments,o)}else{a=r.apply(this,arguments)}return _possibleConstructorReturn(this,a)}}function _possibleConstructorReturn(e,_){if(_&&(_typeof(_)==="object"||typeof _==="function")){return _}else if(_!==void 0){throw new TypeError("Derived constructors may only return object or undefined")}return _assertThisInitialized(e)}function _assertThisInitialized(e){if(e===void 0){throw new ReferenceError("this hasn't been initialised - super() hasn't been called")}return e}function _isNativeReflectConstruct(){if(typeof Reflect==="undefined"||!Reflect.construct)return false;if(Reflect.construct.sham)return false;if(typeof Proxy==="function")return true;try{Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],(function(){})));return true}catch(e){return false}}function _getPrototypeOf(e){_getPrototypeOf=Object.setPrototypeOf?Object.getPrototypeOf:function e(_){return _.__proto__||Object.getPrototypeOf(_)};return _getPrototypeOf(e)}var __signature__=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default.signature:function(e){return e};var WalletUvad=function(_Component){_inherits(WalletUvad,_Component);var _super=_createSuper(WalletUvad);function WalletUvad(e){_classCallCheck(this,WalletUvad);return _super.call(this,e)}_createClass(WalletUvad,[{key:"render",value:function e(){var _=this;var t=this.props.match;return react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"table-wrapper"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(Components_PageTitleBar_PageTitleBar__WEBPACK_IMPORTED_MODULE_8__["a"],{title:react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(Util_IntlMessages__WEBPACK_IMPORTED_MODULE_9__["a"],{id:"sidebar.wallet.uvad.title"}),match:t}),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(reactstrap__WEBPACK_IMPORTED_MODULE_1__["a"],null,react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(reactstrap__WEBPACK_IMPORTED_MODULE_2__["a"],{row:true},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"help-text d-flex p-10"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("i",{className:"ti-info-alt mr-15 pt-5"}),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("span",null,"The wallet key must be in (UVAD).")),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",null,react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("img",{src:__webpack_require__(1532),height:"55"}))),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(reactstrap__WEBPACK_IMPORTED_MODULE_2__["a"],{row:true},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(reactstrap__WEBPACK_IMPORTED_MODULE_3__["a"],{for:"receive",sm:3},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(Util_IntlMessages__WEBPACK_IMPORTED_MODULE_9__["a"],{id:"sidebar.wallet.uvad.title"})),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(reactstrap__WEBPACK_IMPORTED_MODULE_4__["a"],{sm:9},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(reactstrap__WEBPACK_IMPORTED_MODULE_5__["a"],{type:"text",name:"receive",id:"receive",className:"input-lg"}))),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(reactstrap__WEBPACK_IMPORTED_MODULE_2__["a"],{row:true},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(reactstrap__WEBPACK_IMPORTED_MODULE_4__["a"],{sm:4},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(_material_ui_core_Button__WEBPACK_IMPORTED_MODULE_6__["a"],{variant:"contained",color:"primary",className:"text-white",onClick:function e(){return _.onUpdateProfile()}},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(Util_IntlMessages__WEBPACK_IMPORTED_MODULE_9__["a"],{id:"sidebar.register"}))))))}},{key:"__reactstandin__regenerateByEval",value:function __reactstandin__regenerateByEval(key,code){this[key]=eval(code)}}]);return WalletUvad}(react__WEBPACK_IMPORTED_MODULE_0__["Component"]);var _default=WalletUvad;__webpack_exports__["default"]=_default;(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default:undefined;if(!e){return}e.register(WalletUvad,"WalletUvad","D:\\v3\\bloomtech-react\\src\\routes\\wallet\\uvad\\index.js");e.register(_default,"default","D:\\v3\\bloomtech-react\\src\\routes\\wallet\\uvad\\index.js")})();(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.leaveModule:undefined;e&&e(module)})()}).call(this,__webpack_require__(7)(module))},1532:function(e,_,t){e.exports=t.p+"static/media/uvad.ed1425ef.png"},1542:function(e,_,t){"use strict";var r=t(4);var a=t(25);var o=t(0);var n=t.n(o);var l=t(1);var c=t.n(l);var i=t(15);var u=t.n(i);var s=t(9);var f=["className","cssModule","widths","tag"];var E=["xs","sm","md","lg","xl"];var p=c.a.oneOfType([c.a.number,c.a.string]);var d=c.a.oneOfType([c.a.bool,c.a.number,c.a.string,c.a.shape({size:c.a.oneOfType([c.a.bool,c.a.number,c.a.string]),order:p,offset:p})]);var O={tag:s["o"],xs:d,sm:d,md:d,lg:d,xl:d,className:c.a.string,cssModule:c.a.object,widths:c.a.array};var P={tag:"div",widths:E};var M=function e(_,t,r){if(r===true||r===""){return _?"col":"col-"+t}else if(r==="auto"){return _?"col-auto":"col-"+t+"-auto"}return _?"col-"+r:"col-"+t+"-"+r};var D=function e(_){var t=_.className,o=_.cssModule,l=_.widths,c=_.tag,i=Object(a["a"])(_,f);var E=[];l.forEach((function(e,t){var r=_[e];delete i[e];if(!r&&r!==""){return}var a=!t;if(Object(s["i"])(r)){var n;var l=a?"-":"-"+e+"-";var c=M(a,e,r.size);E.push(Object(s["k"])(u()((n={},n[c]=r.size||r.size==="",n["order"+l+r.order]=r.order||r.order===0,n["offset"+l+r.offset]=r.offset||r.offset===0,n)),o))}else{var f=M(a,e,r);E.push(f)}}));if(!E.length){E.push("col")}var p=Object(s["k"])(u()(t,E),o);return n.a.createElement(c,Object(r["a"])({},i,{className:p}))};D.propTypes=O;D.defaultProps=P;_["a"]=D}}]);