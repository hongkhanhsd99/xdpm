package returnbike.payment;

import rentBike.NoticeDialog;
import staticdata.PaymentData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentDialog extends JDialog {
    private JLabel viewCardID;
    private JLabel viewOwner;
    private JLabel viewCVVCode;
    private JLabel viewDateExpired;

    private JTextField cardID;
    private JTextField Owner;
    private JTextField CVVCode;
    private JTextField dateExpired;

    private GridBagLayout layout;
    private GridBagConstraints c;

    private IPaymentController controller;


    public PaymentDialog(IPaymentController controller) {
        super((Frame) null, "Payment", true);

        viewCardID = new JLabel("Số tài khoản: ");
        viewOwner = new JLabel("Tên chủ tài khoản: ");
        viewCVVCode = new JLabel("CVVCode: ");
        viewDateExpired = new JLabel("Ngày hết hạn: ");

        cardID = new JTextField(15);
        Owner = new JTextField(15);
        CVVCode = new JTextField(15);
        dateExpired = new JTextField(15);

        try {
            if (PaymentData.owner.length() != 0) {
                cardID.setText(PaymentData.owner);
            }

            if (PaymentData.accountNumber.length() != 0) {
                Owner.setText(PaymentData.accountNumber);
            }
            if (PaymentData.CVVCode.length() != 0) {
                CVVCode.setText(PaymentData.CVVCode);
            }
            if (PaymentData.dateExpire.length() != 0) {
                dateExpired.setText(PaymentData.dateExpire);
            }

            System.out.println("PaymentDialog được khởi tạo");
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        this.controller = controller;

        setContentPane(new JPanel());
        layout = new GridBagLayout();
        getContentPane().setLayout(layout);
        c = new GridBagConstraints();

        c.gridy = getLastRowIndex();
        c.gridx = 1;
        getContentPane().add(viewCardID, c);
        c.gridx = 2;
        getContentPane().add(cardID, c);


        c.gridy = getLastRowIndex();
        c.gridx = 1;
        getContentPane().add(viewOwner, c);
        c.gridx = 2;
        getContentPane().add(Owner, c);

        c.gridy = getLastRowIndex();
        c.gridx = 1;
        getContentPane().add(viewCVVCode, c);
        c.gridx = 2;
        getContentPane().add(CVVCode, c);

        c.gridy = getLastRowIndex();
        c.gridx = 1;
        getContentPane().add(viewDateExpired, c);
        c.gridx = 2;
        getContentPane().add(dateExpired, c);

        JButton submitButton = new JButton("Xác nhận");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (new CheckAccountParams().checkPaymentParams(Owner.getText(), cardID.getText())) {
//                    PaymentData.owner = Owner.getText();
//                    PaymentData.accountNumber = cardID.getText();
//                    controller.pay(PaymentData.accountNumber);
//                    PaymentDialog.this.dispose();
//                } else {
//                    System.out.println("Nhập sai định dạng tài khoản ! :)");
//                    new NoticeDialog().setVisible(true);
//                }
            }

        });
        c.gridx = 1;
        c.gridy = getLastRowIndex();
        getContentPane().add(submitButton, c);

        JButton cancelButton = new JButton("Hủy bỏ");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentDialog.this.dispose();
            }
        });
        c.gridx = 2;
        getContentPane().add(cancelButton, c);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    private int getLastRowIndex() {
        layout.layoutContainer(getContentPane());
        int[][] dim = layout.getLayoutDimensions();

        int rows = dim[1].length;
        return rows;
    }


}
