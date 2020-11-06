import utils.tools;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class zSound {
    public static void main(String[] args) {
        new zSound("./ProjectEuler-//ProjectEuler//sound//StarWars3.wav");
    }

    public zSound(String clickSound) {
        SoundEffect se = new SoundEffect();
        if (new File(clickSound).exists()) {
            se.setFile(clickSound);
        } else {
            tools.d("File does not exist, current path:" + System.getProperty("user.dir"));
        }

        ButtonHandler bHandler = new ButtonHandler(se, clickSound);

        JFrame window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        Container con = window.getContentPane();
        window.setVisible(true);

        /*buttonPanel = new JPanel();
        buttonPanel.setBounds(300,300,200,100);
        buttonPanel.setBackground(Color.black);
        con.add(buttonPanel);*/

        //JPanel buttonPanel;
        JButton soundButton = new JButton("Sound Effect");
        soundButton.setBounds(300, 300, 200, 50);
        soundButton.setBackground(Color.black);
        soundButton.addActionListener(bHandler);
        con.add(soundButton);


    }

    public class SoundEffect {
        private Clip clip;

        public void setFile(String soundFileName) {
            try {
                File file = new File(soundFileName);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            } catch (Exception ignored) {
                tools.d(ignored);
            }
        }

        public void play() {
            clip.setFramePosition(0);
            clip.start();
        }

    }

    public class ButtonHandler implements ActionListener {
        private final SoundEffect soundE;
        private final String clickSound;

        public ButtonHandler(SoundEffect s, String clickSound) {
            this.soundE = s;
            this.clickSound = clickSound;
        }

        public void actionPerformed(ActionEvent event) {
            soundE.setFile(clickSound);
            soundE.play();


        }
    }
}
