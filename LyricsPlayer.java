import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;

public class LyricsPlayer extends JFrame {
    private JLabel showLyrics;
    private Clip rewriteAudio;
    private String[][] syncLyr;
    private long starting;  
    private Image backgroundImage; // Variable to hold the background image

    public LyricsPlayer() {
        setTitle("Lyrics Player - Rewrite the Stars");
        setSize(700, 450); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.LIGHT_GRAY);

        // Load the background image
        backgroundImage = new ImageIcon("photo.jpg").getImage(); // Ensure you have this image

        // Lyrics display (centered)
        showLyrics = new JLabel("", SwingConstants.CENTER); 
        showLyrics.setFont(new Font("Chalkboard", Font.BOLD, 28));
        showLyrics.setForeground(new Color(54, 69, 79)); // Dark Slate Gray font color
        showLyrics.setOpaque(false); // Make it transparent to show background
        showLyrics.setBackground(new Color(255, 223, 186)); // Light peach background for lyrics
        showLyrics.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(54, 69, 79), 4), // Dark border
                BorderFactory.createEmptyBorder(20, 20, 20, 20) // Padding around text
        ));
        add(showLyrics, BorderLayout.CENTER);

        // Play button at the bottom
        JButton playButton = new JButton("Play Song");
        playButton.setFont(new Font("Arial", Font.BOLD, 16));
        playButton.addActionListener(e -> playSong());
        add(playButton, BorderLayout.SOUTH);

        // Lyrics synchronization data with timing
        syncLyr = new String[][] {
            {"00:00", "Rewrite the stars"},
            {"00:02", "You know I want you"},
            {"00:06", "It's not a secret I try to hide"},
            {"00:09", "I know you want me"},
            {"00:14", "So don't keep saying our hands are tied"},
            {"00:17", "You claim it's not in the cards"},
            {"00:20", "And fate is pullin' you miles away"},
            {"00:23", "And out of reach from me"},
            {"00:25", "But you're here in my heart"},
            {"00:28", "So who can stop me if I decide"},
            {"00:31", "That you're my destiny"},
            {"00:36", "What if we rewrite the stars?"},
            {"00:40", "Say you were made to be mine"},
            {"00:43", "Nothing can keep us apart"},
            {"00:46", "You'd be the one I was meant to find"},
            {"00:48", "You’re the one I was meant to find"},
            {"00:50", "It’s up to you, it’s up to me"},
            {"00:55", "No one can say what we get to be"},
            {"00:59", "So why don’t we rewrite the stars?"},
            {"01:02", "Maybe the world could be ours"},
            {"01:05", "Tonight"},
            {"01:16", "You think it's easy"},
            {"01:19", "You think I don't wanna run to you"},
            {"01:23", "But there are mountains"},
            {"01:26", "And there are doors that we can't walk through"},
            {"01:31", "I know you're wondering why because we're able to be"},
            {"01:35", "Just you and me within these walls"},
            {"01:39", "But when we go outside, you're gonna wake up and see"},
            {"01:43", "That it was hopeless after all"},
            {"01:52", "No one can rewrite the stars"},
            {"01:55", "How can you say you'll be mine?"},
            {"02:00", "Everything keeps us apart"},
            {"02:04", "And I'm not the one you were meant to find"},
            {"02:06", "It's not up to you"},
            {"02:08", "It's not up to me"},
            {"02:11", "When everyone tells us what we can be"},
            {"02:14", "How can we rewrite the stars?"},
            {"02:17", "Say that the world can be us"},
            {"02:19", "Tonight"},
            {"02:23", "All I want is to fly with you"},
            {"02:28", "All I want is to fall with you"},
            {"02:31", "So just give me all of you"},
            {"02:33", "It feels impossible"},
            {"02:35", "It's not impossible"},
            {"02:37", "Say that it's possible"},
            {"02:40", "How do we rewrite the stars"},
            {"02:43", "Say you were made to be mine?"},
            {"02:47", "Nothing can keep us apart"},
            {"02:51", "Cause you are the one I was meant to find"},
            {"02:53", "It's up to you"},
            {"02:56", "And it's up to me"},
            {"03:00", "No one can say what we get to be"},
            {"03:04", "And why don't we rewrite the stars?"},
            {"03:07", "Changing the world to be ours"},
            {"03:21", "You know I want you"},
            {"03:24", "It's not a secret I try to hide"},
            {"03:27", "But I can't have you"},
            {"03:32", "We're bound to break and my hands are tied"}
        };
    }

    // Override the paint method to draw the background image
    @Override
    public void paint(Graphics g) {
        super.paint(g); // Call the superclass's paint method
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); // Draw the image to fill the frame
    }

    // Play "Rewrite the Stars" audio
    private void playSong() {
        try {
            // Create audio clip
            rewriteAudio = AudioSystem.getClip();
            
            // Load audio file
            File audioFile = new File("Rewrite the stars.wav");
            if (!audioFile.exists()) {
                System.err.println("Audio file not found at: " + audioFile.getAbsolutePath());
                return;
            }

            rewriteAudio.open(AudioSystem.getAudioInputStream(audioFile));
            rewriteAudio.start();
            starting = System.currentTimeMillis(); 

            // Start syncing lyrics
            new Thread(this::syncLyrics).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Syncing lyrics with the song
    private void syncLyrics() {
        try {
            for (String[] lyric : syncLyr) {
                String orasNa = lyric[0]; 
                String lines = lyric[1];

                String[] timeParts = orasNa.split(":");
                int seconds = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
                long linesTimes = seconds * 1000; 

                long lapas = System.currentTimeMillis() - starting;

                // Delay the display of lyrics
                if (linesTimes > lapas) {
                    Thread.sleep(linesTimes - lapas);
                }

                showLyrics.setText(lines);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LyricsPlayer player = new LyricsPlayer();
            player.setVisible(true);
        });
    }
}
