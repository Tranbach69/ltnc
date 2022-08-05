
public class Main {

    
    public static void main(String[] args) {
        ChangeBaseNumber convert = new ChangeBaseNumber();
        while(true){
        // user choose the base number input
        int BaseNumberFrom = convert.ChooseBaseNumberInput();
        // user choose the base number out
        int BaseNumberTo = convert.ChooseBaseNumberOut();
        // required user enter the input value
        String valueInput = convert.InputValue(BaseNumberFrom);
        // Program process
        String  valueOutput=  convert.ConvertBaseNumber(valueInput, BaseNumberFrom, BaseNumberTo);
        // print output value
        convert.DisplayValue(valueOutput, BaseNumberTo);
        }
    }
    
}
