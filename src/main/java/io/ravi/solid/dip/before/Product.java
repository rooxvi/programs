package io.ravi.solid.dip.before;

public class Product {

    private BackendDeveloper javaDeveloper = new BackendDeveloper();
    private FrontendDeveloper javascriptDeveloper = new FrontendDeveloper();

    private void implement(){
        javaDeveloper.writeJavaCode();
        javascriptDeveloper.writeJavascriptCode();
    }
}
