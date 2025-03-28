public class Cart {
    private int qtyOrdered =0;
    public static final int MAX_NUMBERS_ORDERED =20;
    private  DigitalVideoDisc itemOrdered [] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    //add DVD to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc item){
        if(qtyOrdered == MAX_NUMBERS_ORDERED ){
            System.out.println("The cart is almnost full");
        }else{
            itemOrdered[qtyOrdered] = item;
            qtyOrdered++;
            System.out.println("The dvd with title " + item.getTitle() + " has been added to the cart");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        for(DigitalVideoDisc dvd : dvdList){
            if(qtyOrdered == MAX_NUMBERS_ORDERED){
                System.out.println("The cart is almnost full");
                break;
            }
            itemOrdered[qtyOrdered] = dvd;
            qtyOrdered++;
            System.out.println("The dvd with title " + dvd.getTitle() + " has been added to the cart");
        }
    }




    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("Do not have enough space to add both DVD");
        }else{
            if(qtyOrdered == MAX_NUMBERS_ORDERED - 1){
                itemOrdered[qtyOrdered++]=dvd1;
                System.out.println("The dvd with title " + dvd1.getTitle() + " has been added to the cart");
                System.out.println("After add dvd1,the cart is full, cant not add dvd2");
            }else {
                itemOrdered[qtyOrdered++] = dvd1;
                System.out.println("The dvd with title " + dvd1.getTitle() + " has been added to the cart");
                itemOrdered[qtyOrdered++] = dvd2;
                System.out.println("The dvd with title " + dvd2.getTitle() + " has been added to the cart");
            }

        }
    }



    //remove DVD to cart
    boolean found =false;
    public void removeDigitalVideoDisc(DigitalVideoDisc item){
        if ( qtyOrdered ==0){
            System.out.println("The cart has no DVD");
        }else{
            //search the disc
            for (int i=0; i<qtyOrdered;i++){
                if(itemOrdered[i].equals(item)){
                    found =true;
                    //If DVD match, take all the dvd right of itemOrder[i] to the left
                    for(int j=i; j< qtyOrdered -1; j++){
                        itemOrdered[j] = itemOrdered[j+1];
                    }
                    itemOrdered[qtyOrdered-1] = null;
                    qtyOrdered--;
                    System.out.println("The DVD with title " + item.getTitle() + " has been removed from the cart");
                }
            }
            if(!found){
                System.out.println("The DVD is not match with any DVD in the cart");
            }
        }


    }
    float total =0;
    public float totalCost(){
        for (int i=0; i< qtyOrdered;i++){
            total+=itemOrdered[i].getCost();
        }
        return total;
    }

    //display
    public void display(){
        System.out.println("The cart has " + qtyOrdered + " DVDs: ");
        for(int i = 0; i < qtyOrdered; i ++){
            System.out.println(itemOrdered[i].getTitle());
        }
    }
}
