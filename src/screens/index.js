import { Navigation } from 'react-native-navigation';

import DemoScreen from './DemoScreen';

export default function () {
  Navigation.registerComponent('example.DemoScreen', () => DemoScreen);
}
