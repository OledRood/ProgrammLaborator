class Laba2 {
    public static void main(String[] args) {
        SocialNetwork facebook = new SocialNetwork("Facebook", "/Facebook/mainIcon",
                0, "Meta", 1, "");
        facebook.showInfo();
        // Game civilization = new Game("civilization", "civilization/mainIcon", 0,
        // "Pamelo", "");
        // civilization.run();
        // civilization.populationUpdate(5);

    }
}

abstract class Aplication {
    private String name;
    private String iconPath;
    private int unreadNotifications;
    private String developer;
    private String additionalInformation;

    private static int countOfAplications = 0;

    public Aplication(String name, String iconPath, int unreadNotifications, String developer,
            String additionalInformation) {
        this.name = name;
        this.iconPath = iconPath;
        this.unreadNotifications = unreadNotifications;
        this.developer = developer;
        this.additionalInformation = additionalInformation;

        countOfAplications++; // Обновляется счетчик приложений
    }

    public Aplication() {
        this("Unknow", "/System/images/defaultIcon", 0, "Unknow,", "");
        countOfAplications++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public int getUnreadNotifications() {
        return unreadNotifications;
    }

    public void setUnreadNotifications(int unreadNotifications) {
        this.unreadNotifications = unreadNotifications;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getCountOfAplications() {
        return countOfAplications;
    }

    public void setInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getInformation() {
        return additionalInformation;
    }

    public abstract void run();

    public void updateNotification(int countNewNotification) {
        unreadNotifications += countNewNotification;
    };

    public void showInfo() {
        System.out.println(
                "Приложение: " + name + ", Разработчик: " + developer + ", Уведомления: " + unreadNotifications
                        + ", Дополнительная информация: " + additionalInformation);
    }
}

class SocialNetwork extends Aplication {

    private int usersCount;

    public SocialNetwork(String name, String iconPath, int unreadNotifications, String developer, int usersCount,
            String additionalInformation) {
        super(name, iconPath, unreadNotifications, developer, additionalInformation);
        this.usersCount = usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public int getUsersCount() {
        return usersCount;
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Социальная сеть: " + getName() + ", Разработчик: " + getDeveloper() + ", Количество пользователей: "
                        + usersCount + ", Уведомления: " + getUnreadNotifications() + ", Дополнительная информация: "
                        + getInformation());
    }

    @Override
    public void run() {
        String name = getName();
        System.out.println("run " + name);
    }

    public void newUser() {
        usersCount++;
    }

}

class Game extends Aplication {
    private int wood;
    private int stone;
    private int population;

    private String savePath;

    private static int saveNumber = 0;

    public Game(String name, String iconPath, int unreadNotifications, String developer,
            String additionalInformation) {
        super(name, iconPath, unreadNotifications, developer, additionalInformation);
        this.savePath = "";
    }

    public int getPopulation() {
        return population;
    }

    public int getStone() {
        return stone;
    }

    public int getWood() {
        return wood;
    }

    @Override
    public void run() {
        if (savePath == "")
            createSaveData();

        openSaveData();
        System.out.println(savePath);
    }

    private void createSaveData() {
        saveNumber++;
        this.savePath = "C//SaveData//Data//" + getName() + "//" + saveNumber + "[0,0,0]";
    }

    private void openSaveData() {
        int startIndex = savePath.indexOf("[") + 1;
        int endIndex = savePath.indexOf("]");

        String[] massiveString = savePath.substring(startIndex, endIndex).split(",");
        wood = Integer.parseInt(massiveString[0]);
        stone = Integer.parseInt(massiveString[1]);
        population = Integer.parseInt(massiveString[2]);
    }

    public void save() {
        int endIndex = savePath.indexOf("[");
        savePath = savePath.substring(0, endIndex) + "[" + wood + "," + stone + "," + population + "]";
        System.out.println("Data is saved");
        ;
    }

    public void populationUpdate(int newMemebers) {
        population += newMemebers;
    }

    public void hacking() {
        wood += 3;
    }
}

class Weather extends Aplication {
    private int day;

    public Weather(String name, String iconPath, int unreadNotifications, String developer,
            String additionalInformation, int day) {
        super(name, iconPath, unreadNotifications, developer, additionalInformation);
        this.day = day;
    }

    @Override
    public void run() {
        System.out.println(getName() + "is run");
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

}