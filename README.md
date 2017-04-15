Version Info Material Dialog
============================

A simple and quick to use Android library which changes the colour of text; compatible all the way down to API 1.

Screenshots
-----------
<img src="/screenshots/screenshot-01.png" height="250"> <img src="/screenshots/screenshot-02.png" height="250"> <img src="/screenshots/screenshot-03.png" height="250"> <img src="/screenshots/screenshot-04.png" height="250"> <img src="/screenshots/screenshot-05.png" height="250">

Dependencies
------------
To use the library, add the dependency to your app module's build.grade file:
```gradle
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    
    // Add this dependency.
    compile 'uk.co.hassie:text-colouriser:0.0.1'
}
```

Example usage 1
---------------
```java

TextView textView = (TextView) findViewById(R.id.textView);

TextColouriser textColouriser = new TextColouriser.Builder(HomeActivity.this)
    .setColour("#000000")
    .setText("Sample text")
    .colourise();

textView.setText(textColouriser.getColourisedText());

```

Example usage 2
---------------
```java

TextView textView = (TextView) findViewById(R.id.textView);

TextColouriser textColouriser = new TextColouriser.Builder(HomeActivity.this)
    .setColour("#FFFFFF")
    .setText(textView)
    .colourise();

textView.setText(textColouriser.getColourisedText());

```

Methods
-------
* <b>TextColouriser</b>
..* <b>getColourisedText()</b> - Returns a spannable with the colour applied to the text.
* <b>TextColouriser.Builder</b>
..* <b>setColour(param)</b> - The colour to be applied to the text. Can either be a hex code as a string or a colour integer value.
..* <b>setText(param)</b> - The text to be colourised. Can be any from the following: Character sequence, resource string, string and text view.

License
-------
Copyright ©2017 Hassie.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.