import java.util.*;
class User {
    private String username;
    private String password;
    private int userid;
    public User(String username, String password,int userid) {
        this.username = username;
        this.password = password;
		this.userid = userid;
    }

    public String getUsername() {
        return username;
    }
	public int getuserid()
	{
		return userid;
	}

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
}


class UserManager {
    private HashMap<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    
    public void registerUser(String username, String password,int userid) {
        User newUser = new User(username, password,userid);
        users.put(username, newUser);
    }

    
    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        if (user != null) {
            return user.authenticate(password);
        } else {
            return false;
        }
    }
}

class Recipe
{
	int Recipeid;
	String title;
	String ingredients;
	String instructions;
	public Recipe(int Recipeid,String title,String ingredients,String instructions)
	{
		this.Recipeid = Recipeid;
		this.title = title;
		this.ingredients = ingredients;
		this.instructions = instructions;
	}
	public int getrecipeid()
	{
		return Recipeid;
	}
	public String gettileofrecipe()
	{
		return title;
	}
	public String getingredients()
	{
		return ingredients;
	}
	public String getinstructions()
	{
		return instructions;
	}
	public void setTitle(String title) {
        this.title = title;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
	
	
}
class RecipeManager
{
	HashMap<Integer,Recipe> recipehashmap;
	List<Recipe> recipelist;
	public RecipeManager()
	{
		recipehashmap = new HashMap<Integer,Recipe>();
		recipelist = new ArrayList<Recipe>();
	}
	
	public void addrecipe(int userid,int recipeid,String title,String ingredients,String instructions)
	{
		Recipe rep = new Recipe(recipeid,title,ingredients,instructions);
		recipelist.add(rep);
		recipehashmap.put(userid,rep);
	}
	public void searchrecipe(String keyterm)
	{
		for(Recipe r:recipelist)
		{
			if(r.gettileofrecipe().equalsIgnoreCase(keyterm))
			{
				System.out.println("Recipe Id: "+r.getrecipeid());
				System.out.println("Recipe Title :"+r.gettileofrecipe());
				System.out.println("Ingredients :"+r.getingredients());
				System.out.println("Instructions :"+r.getinstructions());
			}
			else if(r.getingredients().equalsIgnoreCase(keyterm))
			{
				System.out.println("Recipe Id: "+r.getrecipeid());
				System.out.println("Recipe Title :"+r.gettileofrecipe());
				System.out.println("Ingredients :"+r.getingredients());
				System.out.println("Instructions :"+r.getinstructions());
			}
			else if(r.getinstructions().equalsIgnoreCase(keyterm))
			{
				System.out.println("Recipe Id: "+r.getrecipeid());
				System.out.println("Recipe Title :"+r.gettileofrecipe());
				System.out.println("Ingredients :"+r.getingredients());
				System.out.println("Instructions :"+r.getinstructions());
			}
		}
	}
	public void updateRecipe(int userid, int recipeid, String title, String ingredients, String instructions) {
    Recipe recipe = recipehashmap.get(userid);
    if (recipe != null && recipe.getrecipeid() == recipeid) {
        recipe.setTitle(title);
        recipe.setIngredients(ingredients);
        recipe.setInstructions(instructions);
        System.out.println("Recipe updated successfully.");
    } else {
        System.out.println("Recipe not found or you do not have permission to update it.");
    }
}

	public List<Recipe> viewallrecipe()
	{
		return recipelist;
	}
	
}
class Bookmark
{
	int userid;
	int recipeid;
	String bookmark;
	
	public Bookmark(int userid,int recipeid,String bookmark)
	{
		this.userid = userid;
		this.recipeid = recipeid;
		this.bookmark = bookmark;
	}
	public int getuseridforbookmark()
	{
		return userid;
	}
	public int getrecipeidforbookmark()
	{
		return recipeid;
	}
	public String getbookmark()
	{
		return bookmark;
	}
	
}
class Bookmarkmanager
{
	HashMap<Integer,Bookmark> bookmarkhm;
	public Bookmarkmanager()
	{
		bookmarkhm = new HashMap<Integer,Bookmark>();
	}
	public void addbookmark(int userid,int recipeid,String bookmark)
	{
		Bookmark bm = new Bookmark(userid,recipeid,bookmark);
		bookmarkhm.put(userid,bm);
	}
	
	public void displayallbookmarks(int userid)
	{
		Bookmark bm = bookmarkhm.get(userid);
		if(bm!=null)
		{
			System.out.println("User id :"+bm.getuseridforbookmark());
			System.out.println("Recipe Id :"+bm.getrecipeidforbookmark());
			System.out.println("Book mark :"+bm.getbookmark());
		}
		else{
			System.out.println("No bookmark made ");
		}
	}
	

}

class Recipeapp
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		UserManager usermanager = new UserManager();
		RecipeManager recipemanager = new RecipeManager();
		Bookmarkmanager bookmarkmanager = new Bookmarkmanager();
		
		usermanager.registerUser("Shalini","#bjose12",1);
		usermanager.registerUser("Rakshana","1234",2);
		usermanager.registerUser("Josephine","567",3);
		usermanager.registerUser("Bosco","89",4);
		
		recipemanager.addrecipe(1,1,"Biriyani","Chicken","Add oil");
		
		bookmarkmanager.addbookmark(1,1,"Bookmark");
		
		
		while(true)
		{
			System.out.println("------------------------------------------------------------------------");
			System.out.println("Welcome to Recipe Sharing App");
			System.out.println("You have the options below");
			System.out.println("1.Register User");
			System.out.println("2.Add recipe");
			System.out.println("3.View all recipe");
			System.out.println("4.Book mark");
			System.out.println("5.Search recipe");
			System.out.println("6.Display all bookmarks");
			System.out.println("7.Update");
			System.out.println("8.EXIT");
			
			
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Enter the option below");
			int option = sc.nextInt();
			switch(option)
			{
				case 1:
				{
					System.out.println("Enter the username ");
					String uname = sc.next();
					System.out.println("Enter your password ");
					String pass = sc.next();
					System.out.println("Enter the user id");
					int id = sc.nextInt();
					usermanager.registerUser(uname,pass,id);
					System.out.println("Successfully registered");
					System.out.println("---------------------------------------------------------------------------");
					break;
				}
				case 2:
				{
					System.out.println("Login ");
					System.out.println("Enter the username ");
					String uname = sc.next();
					System.out.println("Enter your password ");
					String pass = sc.next();
					if(usermanager.authenticateUser(uname,pass))
					{
						System.out.println("Enter the user id");
						int uid = sc.nextInt();
						System.out.println("Enter recipe id");
						int rid = sc.nextInt();
						System.out.println("Enter recipe title ");
						String title = sc.next();
						System.out.println("Enter ingredient ");
						String ing = sc.next();
						System.out.println("Enter instructions ");
						String ins = sc.next();
						recipemanager.addrecipe(uid,rid,title,ing,ins);
						System.out.println("Recipe added");
						System.out.println("---------------------------------------------------------------------------");
						
					}
					else{
						System.out.println("Login unsuccessfull");
						
					}  
					break;
				}
				
				case 3:
				{
					System.out.println("Available recipes");
					List<Recipe> allrecipe = recipemanager.viewallrecipe();
					for(Recipe rep :allrecipe)
					{
						System.out.println("Recipe id:"+rep.getrecipeid());
						System.out.println("Recipe title :"+rep.gettileofrecipe());
						System.out.println("Recipe Ingredients :"+rep.getingredients());
						System.out.println("Recipe Instructions :"+rep.getinstructions());
						System.out.println("---------------------------------------------------------------------------");
					}
					break;
				}
				case 4:
				{
					System.out.println("Enter the user id:");
					int userid = sc.nextInt();
					System.out.println("Enter the recipe id:");
					int rid  = sc.nextInt();
					System.out.println("Enter the Book mark as yes");
					String bookmark = "yes";
					bookmarkmanager.addbookmark(userid,rid,bookmark);
					System.out.println("Book marked successfully");
					System.out.println("---------------------------------------------------------------------------");
					break;
				}
				case 5:
				{
					System.out.println("Enter the key to search");
					String key = sc.next();
					recipemanager.searchrecipe(key);
					System.out.println("---------------------------------------------------------------------------");
					break;
					
				}
				case 6:
				{
					System.out.println("Enter the user id:");
					int uid = sc.nextInt();
					bookmarkmanager.displayallbookmarks(uid);
					System.out.println("---------------------------------------------------------------------------");
					break;
				}
				case 7:
				{
					System.out.println("Login ");
					System.out.println("Enter the username ");
					String uname = sc.next();
					System.out.println("Enter your password ");
					String pass = sc.next();
					if(usermanager.authenticateUser(uname,pass))
					{
						System.out.println("Enter the user id");
						int uid = sc.nextInt();
						System.out.println("Enter recipe id");
						int rid = sc.nextInt();
						System.out.println("Enter recipe title ");
						String title = sc.next();
						System.out.println("Enter ingredient ");
						String ing = sc.next();
						System.out.println("Enter instructions ");
						String ins = sc.next();
						recipemanager.updateRecipe(uid,rid,title,ing,ins);
						System.out.println("Recipe added");
						System.out.println("---------------------------------------------------------------------------");
						
					}
					else{
						System.out.println("Login unsuccessfull");
						
					}  
					break;
				}
				case 8:
				{
					return;
					
				}
				
			}
		}
		
		
		
	}
}