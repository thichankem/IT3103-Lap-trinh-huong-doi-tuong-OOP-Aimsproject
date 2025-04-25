public class Cart {
    private int qtyOrdered = 0;
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc itemOrdered [] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public void addDigitalVideoDisc(DigitalVideoDisc item)
    {
        if(qtyOrdered == MAX_NUMBERS_ORDERED)
        {
            System.out.println("full");
        }
        else
        {
            itemOrdered[qtyOrdered] =  item;
            qtyOrdered++;
            System.out.println("the dvd " + item.getTitle() + " has been added to the cart");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList)
    {
        for(DigitalVideoDisc dvd : dvdList){
            if(qtyOrdered == MAX_NUMBERS_ORDERED){
                System.out.println("full");
                break;
            }
            itemOrdered[qtyOrdered] = dvd;
            qtyOrdered++;
            System.out.println("the dvd " + dvd.getTitle() + " has been added to the cart");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered == MAX_NUMBERS_ORDERED)
        {
            System.out.println("full");
        }
        else
        {
            if(qtyOrdered == MAX_NUMBERS_ORDERED - 1)
            {
                itemOrdered[qtyOrdered++]=dvd1;
                System.out.println("the dvd " + dvd1.getTitle() + " has been added to the cart");
                System.out.println("full");
            }
            else 
            {
                itemOrdered[qtyOrdered++] = dvd1;
                System.out.println("the dvd " + dvd1.getTitle() + " has been added to the cart");
                itemOrdered[qtyOrdered++] = dvd2;
                System.out.println("the dvd " + dvd2.getTitle() + " has been added to the cart");
            }

        }
    }
    boolean found = false;
    public void removeDigitalVideoDisc(DigitalVideoDisc item)
    {
        if (qtyOrdered == 0)
        {
            System.out.println("the cart has no DVD");
        }
        else
        {
            for (int i=0;i<qtyOrdered;i++)
            {
                if(itemOrdered[i].equals(item))
                {
                    found = true;
                   
                    for(int j=i;j<qtyOrdered-1;j++)
                    {
                        itemOrdered[j] = itemOrdered[j+1];
                    }
                    itemOrdered[qtyOrdered-1] = null;
                    qtyOrdered--;
                    System.out.println("the DVD " + item.getTitle() + " has been removed from the cart");
                }
            }
            if(!found){
                System.out.println("the DVD is not match with any DVD in the cart");
            }
        }
    }
    float total=0;
    public float totalCost(){
        for (int i=0;i<qtyOrdered;i++)
        {
            total+=itemOrdered[i].getCost();
        }
        return total;
    }
    public void display()
    {
        System.out.println("The cart has " + qtyOrdered + " DVDs: ");
        for(int i=0; i<qtyOrdered; i++)
        {
            System.out.println(itemOrdered[i].getTitle());
        }
    }
}
