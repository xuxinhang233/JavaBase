import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lenovo
 * @Date: 2021/10/28 11:04
 * @Desc: 描述多态性
 */
public class _02_polymorphism {
    public static class Instrument {
        public void play() {
            System.out.println("Instrument is playing...");
        }
    }

    public static class Wind extends Instrument {
        @Override
        public void play() {
            System.out.println("Wind is playing...");
        }
    }

    public static class Percussion extends Instrument {
        @Override
        public void play() {
            System.out.println("Percussion is playing...");
        }
    }

    public static class Music {
        public static void main(String[] args) {
            List<Instrument> instruments = new ArrayList<>();
            instruments.add(new Wind());
            instruments.add(new Percussion());
            instruments.add(new Instrument());
            for (Instrument instrument : instruments) {
                instrument.play();
            }
        }
    }
}