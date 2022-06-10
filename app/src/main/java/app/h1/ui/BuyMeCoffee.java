package app.h1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import app.h1.R;
import co.paystack.android.Paystack;
import co.paystack.android.PaystackSdk;
import co.paystack.android.Transaction;
import co.paystack.android.model.Card;
import co.paystack.android.model.Charge;

public class BuyMeCoffee extends AppCompatActivity {

    ImageView m_img1, m_img2, m_img3, m_back;
    Button m_donate;
    private static final int m_default = 1000;
    EditText m_card_number, m_card_expiry_year, m_card_expiry_month, m_card_cvv, m_sender_email;

    int m_amount_naira;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buymecoffee);

        m_back = findViewById(R.id.back);
        m_img1 = findViewById(R.id.imageView1);
        m_img2 = findViewById(R.id.imageView2);
        m_img3 = findViewById(R.id.imageView3);
        m_donate = findViewById(R.id.startTransaction);
        m_sender_email = findViewById(R.id.editTextUserEmail);


        m_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BuyMeCoffee.this, AboutActivity.class);
                startActivity(i);
            }
        });
        m_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_donate.setText("Send N1,000");
                m_amount_naira = 1000;
            }
        });

        m_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_donate.setText("Send N3,000");
                m_amount_naira = 3000;

            }
        });

        m_img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_donate.setText("Send N5,000");
                m_amount_naira = 5000;

            }
        });

        PaystackSdk.initialize(getApplicationContext());
    }

    public void initializePaystack(View view) {

        int expiryMonth = 0;
        int expiryYear = 0;

        m_card_number = findViewById(R.id.editTextCardNumber);
        m_card_expiry_year = findViewById(R.id.editTextExpiryYear);
        m_card_expiry_month = findViewById(R.id.editTextExpiryMonth);
        m_card_cvv = findViewById(R.id.editTextCVV);


        String cardNumber = m_card_number.getText().toString();
        if(!m_card_expiry_month.getText().toString().isEmpty()) {
            expiryMonth = Integer.parseInt(m_card_expiry_month.getText().toString());
        }

        if(!m_card_expiry_year.getText().toString().isEmpty()) {
            expiryYear = Integer.parseInt(m_card_expiry_year.getText().toString());
        }

        String cvv = m_card_cvv.getText().toString();

        Card card = new Card(cardNumber, expiryMonth, expiryYear, cvv);

        if (card.isValid()) {
            // charge card
            Charge charge = new Charge();
            charge.setCard(card);

            String senderEmail = m_sender_email.getText().toString();

            charge.setEmail(senderEmail);

            charge.setAmount(100); //test amount
            dialog = new ProgressDialog(BuyMeCoffee.this);
            String newLine = "\n";
            dialog.setMessage("Performing transaction..." + newLine + "Please wait");
            dialog.show();

            PaystackSdk.chargeCard(BuyMeCoffee.this, charge, new Paystack.TransactionCallback() {
                @Override
                public void onSuccess(Transaction transaction) {
                    // This is called only after transaction is deemed successful.
                    // Retrieve the transaction, and send its reference to your server
                    // for verification.
                    String paymentReference = transaction.getReference();
                    dialog.dismiss();
                    Toast.makeText(BuyMeCoffee.this, "Transaction Successful! payment reference: "
                            + paymentReference, Toast.LENGTH_LONG).show();
                }

                @Override
                public void beforeValidate(Transaction transaction) {

                }

                @Override
                public void onError(Throwable error, Transaction transaction) {

                }
            });

            Toast.makeText(BuyMeCoffee.this, card.getType(), Toast.LENGTH_SHORT).show();

            Toast.makeText(BuyMeCoffee.this, "Card is valid", Toast.LENGTH_SHORT).show();
        } else {
            //do something
            Toast.makeText(BuyMeCoffee.this, "Card is not valid", Toast.LENGTH_SHORT).show();
        }
    }
}