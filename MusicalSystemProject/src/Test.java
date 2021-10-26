public class Test {
    /*
    Класс для тестирования
     */
    public static void main(String[] args) {
        Song song1 = new Song("THE BEST TITLE", "Ivanov Ivan Ivanovich");
        Song song2 = new Song("UNIVERSITY TITLE", "Ivanov Ivan Ivanovich");

        CD cd1 = new CD();
        cd1.getSongList().addSong(song1);
        cd1.getSongList().addSong(song2);

        FlashDrive fd1 = new FlashDrive();
        fd1.getSongList().addSong(song1);

        CDPlayer cdpl = new CDPlayer();
        cdpl.playSong(cd1);
        cdpl.setNextSong(cd1);
        cdpl.playSong(cd1);
        cdpl.playSong(fd1);

    }
}
