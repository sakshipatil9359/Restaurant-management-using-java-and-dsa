import java.util.*;


class details_node{
    String food_name;
    double food_price;
    int food_quantity;
    details_node next;
    details_node prev;

    details_node(String f,double p,int q)
    {
        food_name = f;
        food_price = p;
        food_quantity = q;
        next = null;
        prev = null;
    }
}
class Resto{
    details_node head;
    details_node headc;
    Scanner sc=new Scanner(System.in);

    void create_food_list(String f_name,double f_price,int f_q)		//create a list of food
    {
        details_node ptr = null;
        details_node nn=new details_node(f_name,f_price,f_q);
        if(head==null)
        {
            head=nn;
            return;
        }else {
            ptr=head;
            while(ptr.next!=null)
            {
                ptr=ptr.next;
            }
            ptr.next = nn;
            nn.prev = ptr;
        }
    }
    void display_food_list()
    {
        details_node ptr = null;
        if(head==null)
        {
            System.out.println("Please create food menu to display");
        }else {
            ptr=head;
            System.out.println("Menu \t\t Price \t\t Quantity");
            System.out.println("--------------------------------------------");
            while(ptr!=null)
            {
                System.out.println(ptr.food_name+" \t\t "+ptr.food_price+" \t\t "+ptr.food_quantity);
                ptr=ptr.next;
            }
            System.out.println("--------------------------------------------");
        }

    }

    void delete_food_item( details_node head){
       boolean itemfound=false;
        details_node ptr=null;

        String foodname_to_delete;
        System.out.println("Enter a food item name from displayed menu to delete");
        foodname_to_delete=sc.nextLine();
        if(head==null){
            System.out.println("--------------------------------------------");
            System.out.println("Food list is empty can't delete ");
            System.out.println("--------------------------------------------");
        }else{
            //to delete 1st node
            if(head.food_name.equals(foodname_to_delete)){
               head=head.next;
                System.out.println("Food item deleted successfully");
                itemfound=true;
                return;

            }else {

                ptr = head;
                while (ptr != null) {
                    // to delete last node
                    if (ptr.food_name.equals(foodname_to_delete)) {
                        if (ptr.next == null) {
                            ptr.prev.next = null;
                            ptr.prev = null;
                            System.out.println("Food item deleted successfully");
                            itemfound = true;
                            break;
                        }
                        //to delete middle node
                        ptr.prev.next = ptr.next;
                        ptr.next.prev = ptr.prev;
                        ptr.next = null;
                        ptr.prev = null;
                        itemfound = true;
                        System.out.println("Food item deleted successfully");
                        break;
                    } else {

                        ptr = ptr.next;
                    }
                }
                if (itemfound == false) {
                    System.out.println("--------------------------------------------");
                    System.out.println("Food item not found ");
                    System.out.println("--------------------------------------------");
                }
            }

        }
    }

    void update_item(){
        boolean itemfound=false;
        details_node ptr=null;
        int option;
        String food_name,updated_name;
        int nprice,nquantity;
        System.out.println("Enter a food item name from displayed menu to delete");
        food_name=sc.nextLine();
        if(head==null){
            System.out.println("--------------------------------------------");
            System.out.println("Food list is empty can't delete ");
            System.out.println("--------------------------------------------");
        }else{
            ptr=head;
            while(ptr!=null){
                if(ptr.food_name.equals(food_name)){
                    itemfound=true;
                    System.out.println("--------------------------------------------");
                    System.out.println("Enter 1 to edit dish name");
                    System.out.println("Enter 2 to edit price");
                    System.out.println("Enter 3 to edit quantity");
                    System.out.println("Enter 4 to exit");
                    System.out.println("--------------------------------------------");

                    System.out.println("Enter the option of operation you wants to perform :-");
                    option=sc.nextInt();
                    sc.nextLine();
                    if(option==4){
                        break;
                    }
                    switch (option){
                        case  1:
                            System.out.println("Enter a food name to update instead if ' " +food_name+" '");
                            updated_name=sc.nextLine();
                            ptr.food_name=updated_name;
                            System.out.println("food name "+food_name+" is updated to "+updated_name+" successfully.....");
                            break;
                        case 2:
                            System.out.println("Enter the new price to be updated :-");
                            nprice=sc.nextInt();
                            sc.nextLine();
                            ptr.food_price=nprice;
                            System.out.println("price of  "+food_name+" is updated to "+nprice+" successfully.....");
                            break;
                        case 3:
                            System.out.println("Enter the new quantity to be updated :-");
                            nquantity=sc.nextInt();
                            sc.nextLine();
                            ptr.food_quantity=nquantity;
                            System.out.println("Quantity of "+food_name+" is updated to "+nquantity+" successfully.....");
                            break;

                        default:
                            break;
                    }
                }else {
                    ptr=ptr.next;
                }
            }
            if (itemfound == false) {
                System.out.println("--------------------------------------------");
                System.out.println("Food item not found ");
                System.out.println("--------------------------------------------");
            }
        }
    }
    void create_order_food_list(String f_name,double f_price,int f_q)		//create a list of food
    {
        details_node ptr = null;
        details_node nn=new details_node(f_name,f_price,f_q);
        if(headc==null)
        {
            headc=nn;
            return;
        }else {
            ptr=headc;
            while(ptr.next!=null)
            {
                ptr=ptr.next;
            }
            ptr.next = nn;
            nn.prev = ptr;
        }
    }
 void placeorder(){
        int ans=1;

   display_food_list();
   do {

       boolean itemfound=false;
       details_node ptr=null;

       String food_name;
       double quantity;
       System.out.println("Enter the  food item you want to order");
       food_name=sc.next();
       System.out.println("Enter the quantity you want to order");
       quantity=sc.nextDouble();

//       sc.next();

       double newprice;
       if(head==null){
           System.out.println("--------------------------------------------");
           System.out.println("Food list is empty can't delete ");
           System.out.println("--------------------------------------------");
       }else{

           ptr=head;
           while(ptr!=null){

               if(ptr.food_name.equals(food_name)){


                   itemfound=true;
                   newprice=ptr.food_price*quantity;
                   int nquantity=(int)quantity;
                   create_order_food_list(ptr.food_name,newprice,nquantity);
                   System.out.println("order added");
                   break;
               }else {
                   ptr=ptr.next;
               }
           }
           if (itemfound == false) {
               System.out.println("--------------------------------------------");
               System.out.println("Food item not found ");
               System.out.println("--------------------------------------------");
           }
       }

       System.out.println("Enter 1 to place more order ");

       ans=sc.nextInt();
       sc.nextLine();
   }while(ans==1);
 }
 void vieworder(){
     details_node ptr = null;
     if(headc==null)
     {
         System.out.println("order is not placed yet");
     }else {
         ptr=headc;

         System.out.println("Menu \t\t Price \t\t Quantity");
         System.out.println("--------------------------------------------");
         while(ptr!=null)
         {
             System.out.println(ptr.food_name+" \t\t "+ptr.food_price+" \t\t "+ptr.food_quantity);
             ptr=ptr.next;
         }
         System.out.println("--------------------------------------------");
     }
 }
 void delete_item_order(){

 }
 void finalbill(){
     System.out.println("--------------------------------------------");
     System.out.println("Your order");
     System.out.println("--------------------------------------------");
     vieworder();
      double total=0;
     details_node ptr = null;
     if(headc==null)
     {
         System.out.println("order is not placed yet");
     }else {
         ptr=headc;
         while (ptr!=null){

             total=total+ptr.food_price;
             ptr=ptr.next;
         }

         System.out.println("--------------------------------------------");
     }
     System.out.println("Your total bill is : - "+total);
 }
    void admin(){
        int ch;
        int k=0;
        System.out.println("---------------------Welcome to Paprika Veg Cuisine Admin Section-----------------");

        while(true){

            System.out.println("1:Create food list");
            System.out.println("2:Display food list");
            System.out.println("3:Delete food item");
            System.out.println("4:update food item");
            System.out.println("5 : Back to menu");
            System.out.println("Enter the option of operation you wants to perform :-");
            ch=sc.nextInt();
            sc.nextLine();
            if(ch==5){
                System.out.println("--------------------------THANK YOU---------------------------");
                break;
            }
            switch(ch)
            {
                case 1:
                    String food;
                    double price;
                    int quantity;
                    System.out.println("Enter food:");
                    food = sc.next();
                    System.out.println("Enter price:");
                    price = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter quantity:");
                    quantity = sc.nextInt();
                    sc.nextLine();
                    create_food_list(food, price, quantity);

                    break;
                case 2:
                    display_food_list();
                    break;
                case 3:
                    delete_food_item(head);
                    break;
                case 4:
                    update_item();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please enter a valid choice:");
            }

        }
    }

    void customer(){
        int ch;
        int k=0;
        System.out.println("---------------------Welcome to Paprika Veg Cuisine Admin Section-----------------");

        while(true){

            System.out.println("1:place your order");
            System.out.println("2:view your ordered list ");
            System.out.println("3:delete item from your order");
            System.out.println("4: Final bill");
            System.out.println("5:Back to menu");
            System.out.println("Enter the option of operation you wants to perform :-");
            ch=sc.nextInt();
            sc.nextLine();
            if(ch==5){
                System.out.println("--------------------------THANK YOU---------------------------");
                break;
            }
            switch(ch)
            {
                case 1:
                    placeorder();
                    break;
                case 2:
                    vieworder();
                    break;
                case 3:
                    delete_food_item(headc);
                    break;
                case 4:
                    finalbill();
                    break;
                default:
                    System.out.println("Please enter a valid choice:");
            }

        }

    }
}
public class Main {

  public   void displaymenu(){
        System.out.println("---------------------Welcome to Paprika Veg Cuisine-----------------");
        System.out.println("1 ADMIN SECTION -->");
        System.out.println("2 CUSTOMER SECTION -->");
        System.out.println("3 EXIT");
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        Main m=new Main();
        Resto person = new Resto();
        person.create_food_list("Vada", 30, 3);
        person.create_food_list("Pohe", 10, 2);
        person.create_food_list("Idli", 30, 1);
        person.create_food_list("Momo", 50, 9);
        int ch;
        int k=0;

        while(true)
        {
            m.displaymenu();

            ch=sc.nextInt();
            sc.nextLine();
            if(ch==3){
                System.out.println("--------------------------THANK YOU---------------------------");
                break;
            }
            switch(ch)
            {
                case 1:
                    person.admin();

                    break;
                case 2:
                    person.customer();
                    break;
                case 3:
                    break;


                default:
                    System.out.println("Please enter a valid choice:");
            }

        }
    }
}
