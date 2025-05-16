TextField t1 = new TextField();
TextField t2 = new TextField();
Label l3 = new Label();
l3.textProperty().bind(
    Bindings.concat("T1: ", t1.textProperty(), " | T2: ", t2.textProperty())
);
