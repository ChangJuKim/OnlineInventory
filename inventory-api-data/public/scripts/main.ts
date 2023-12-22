// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyAnvMGf4yC6ct1ud5_R-2eXXm1ehkEJuks",
    authDomain: "onlineinventory-511e7.firebaseapp.com",
    projectId: "onlineinventory",
    storageBucket: "onlineinventory.appspot.com",
    messagingSenderId: "818864680714",
    appId: "1:818864680714:web:5bcce5e8216e0e506794f3",
    measurementId: "G-K71R90PW4J"
  };
  
// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);