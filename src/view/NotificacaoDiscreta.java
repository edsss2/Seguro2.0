package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;

public class NotificacaoDiscreta {

    public static void mostrarNotificacao(JFrame frame, String mensagem) {

        JPanel painelNotificacao = new JPanel();
        painelNotificacao.setBackground(new Color(0, 128, 0)); 
        painelNotificacao.setBounds(0, frame.getHeight() - 50, frame.getWidth(), 50); 
        painelNotificacao.setLayout(new FlowLayout(FlowLayout.LEFT));


        JLabel lblMensagem = new JLabel(mensagem);
        lblMensagem.setForeground(Color.WHITE);
        painelNotificacao.add(lblMensagem);

        frame.getContentPane().add(painelNotificacao);


        Timer timer = new Timer(3000, e -> {
            painelNotificacao.setVisible(false);
        });
        timer.setRepeats(false);
        timer.start();

        painelNotificacao.setVisible(true);
        
        frame.repaint();
    }
}
