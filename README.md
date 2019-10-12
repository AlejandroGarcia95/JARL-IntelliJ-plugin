# JARL IntelliJ plugin

![](jarl_logo.png)

Small IntelliJ plugin for supporting JARL 0.4.1 rule language. It is based on [Sample IntelliJ plugin](https://github.com/antlr/jetbrains-plugin-sample) which makes use of [ANTLRv4 library for IntelliJ plugins](https://github.com/antlr/antlr4-intellij-adaptor/) for translating an ANTLRv4 grammar. 


## Importing and running the project

**Note**: To easily build and test everything from IntelliJ, make sure to have the Gradle plugin installed.

For importing the project the first time, go to `Import`, select the folder and choose `Gradle` as the project type. 

After the IDE is done downloading dependencies and refreshing, you can use the `Gradle` tool window (on the right) to quickly run the project tasks (under `JARL-IntelliJ-plugin > Tasks`). The most important are:

* `other > generateGrammarSource`: parses the `.g4` grammar file with `ANTLR4`.
* `build > assemble`: builds the entire project.
* `build > clean`: erases the whole `build` folder.
* `intellij > runIde` runs the plugin inside a sandbox IntelliJ.


## Installing the plugin

After assembling the whole project, the plugin can be found as a `.zip` file on the `build/distributions` directory.

For installing it on IntelliJ, go to `Preferences > Plugins` and click on the engine on the top right. Then select `Install Plugin from Disk` as browse for the `.zip` file previously mentioned. Note you will need to restart the IDE for the changes to take effect. 