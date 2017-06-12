import { Navigation } from 'react-native-navigation';
import registerScreens from './screens';

// screen related book keeping
registerScreens();

// this will start our app
Navigation.startSingleScreenApp({
  screen: 'example.DemoScreen'
});
