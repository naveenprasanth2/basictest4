package practise8;

enum EnumTest {

    APPLE(500),
    ORANGE(700),

    SUMMA{
        @Override
        public String toString() {
            return "summa";
        }

    };

    int price;

    EnumTest(int val){
        this.price = val;
    }

    EnumTest(){

    }
    public int getPrice(){
        return price;
    }

}
