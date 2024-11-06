import java.util.ArrayList;
import java.util.Objects;

public class Store {
    private ArrayList<CISItem> cisItems;

    public Store(){
        cisItems = new ArrayList<CISItem>();
    }
    public void addBook(Book book){
        cisItems.add(book);
    }

    public void addPhone(Phone phone){
        cisItems.add(phone);
    }

    public void addItem(CISItem item){
        cisItems.add(item);
    }

    public void updatePhonesLocation(String location){
        for(CISItem phone:cisItems){
            if(phone instanceof Phone){
                phone.setLocation(location);
            }
        }
    }

    public ArrayList<CISItem> getAllPhones(){
        ArrayList<CISItem> phoneItems = new ArrayList<CISItem>();
        for(CISItem phone:cisItems){
            if(phone instanceof Phone){
                phoneItems.add(phone);
            }
        }
        return phoneItems;
    }

    public ArrayList<CISItem> getItems(String item){
        ArrayList<CISItem> items = new ArrayList<CISItem>();
        for(CISItem object:cisItems){
            if(item.equals("arduino") && object instanceof Arduino){
                items.add(object);
            }
            else if(item.equals("book") && object instanceof Book){
                items.add(object);
            }
            else if(item.equals("magazine") && object instanceof Magazine){
                items.add(object);
            }
            else if(item.equals("phone") && object instanceof Phone){
                items.add(object);
            }
        }
        return items;
    }

    public void updateItems(String itemType,String property,String value){
        itemType = (char)(itemType.charAt(0)+'A'-'a') + itemType.substring(1);
        for(CISItem object:cisItems){
            if(object.getClass().getSimpleName().equals(itemType)){
                switch(property.toLowerCase()){
                    case "name":
                        object.setName(value);
                        break;
                    case "location":
                        object.setLocation(value);
                        break;
                    case "price":
                        object.setPrice(Integer.parseInt(value));
                        break;
                    case "description":
                        object.setDescription(value);
                        break;
                    case "wordcount":
                        if(object instanceof ReadingItem){
                            ((ReadingItem) object).setWordCount(Integer.parseInt(value));
                        }
                        break;
                    case "datepublished":
                        if(object instanceof ReadingItem){
                            ((ReadingItem) object).setDatePublished(value);
                        }
                        break;
                    case "author":
                        if(object instanceof ReadingItem){
                            ((ReadingItem) object).setAuthor(value);
                        }
                        break;
                    case "isbn":
                        if(object instanceof Book){
                            ((Book) object).setIsbn(value);
                        }
                        break;
                    case "edition":
                        if(object instanceof Book){
                            ((Book) object).setEdition(value);
                        }
                        break;
                    case "title":
                        if(object instanceof Book){
                            ((Book) object).setTitle(value);
                        }
                        break;
                    case "coverstorytitle":
                        if(object instanceof Magazine){
                            ((Magazine) object).setCoverStoryTitle(value);
                        }
                        break;
                    case "printDate":
                        if(object instanceof Magazine){
                            ((Magazine) object).setPrintDate(value);
                        }
                        break;
                    case "storagecapacity":
                        if(object instanceof ElectronicItem){
                            ((ElectronicItem) object).setStorageCapacity(Integer.parseInt(value));
                        }
                        break;
                    case "model":
                        if(object instanceof ElectronicItem){
                            ((ElectronicItem) object).setModel(value);
                        }
                        break;
                    case "maker":
                        if(object instanceof ElectronicItem){
                            ((ElectronicItem) object).setMaker(value);
                        }
                        break;
                    case "operatingsystem":
                        if(object instanceof ElectronicItem){
                            ((ElectronicItem) object).setOperatingSystem(value);
                        }
                        break;
                    case "networktype":
                        if(object instanceof Phone){
                            ((Phone) object).setNetworkType(value);
                        }
                        break;
                    case "screensize":
                        if(object instanceof Phone){
                            ((Phone) object).setScreenSize(Integer.parseInt(value));
                        }
                        break;
                    case "version":
                        if(object instanceof Arduino){
                            ((Arduino) object).setVersion(value);
                        }
                        break;
                }

            }
        }
    }

    public void showAllInfo(){
        for(CISItem item:cisItems){
            System.out.println(item);
        }
    }
}
