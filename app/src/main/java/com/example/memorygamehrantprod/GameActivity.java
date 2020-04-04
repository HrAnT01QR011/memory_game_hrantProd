package com.example.memorygamehrantprod;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private View musicOnOff;
    private boolean isGreen = true;

    private String name;

    private ImageView iv_11, iv_12, iv_13, iv_14, iv_15, iv_16,
            iv_21, iv_22, iv_23, iv_24, iv_25, iv_26,
            iv_31, iv_32, iv_33, iv_34, iv_35, iv_36;

    //Array for the Images**************************************************************************************************
    Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 107, 108, 109, 201, 202, 203, 204, 205, 206, 207, 208, 209};

    //Actual Images*********************************************************************************************************
    int image101, image102, image103, image104, image105, image106, image107, image108, image109,
            image201, image202, image203, image204, image205, image206, image207, image208, image209;

    int firstCard, secondCard;
    int clickFirst, clickSecond;
    int cardNumber = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        Intent intent = getIntent();
        name = intent.getStringExtra("player_name");

        // Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //  Create media
        mediaPlayer = MediaPlayer.create(this, R.raw.memory);
        musicOnOff = findViewById(R.id.music_on_off);
        musicOnOff.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                isGreen = !isGreen;
                if (isGreen) {
                    musicOnOff.setBackground(getDrawable(R.drawable.sound_on));
                    mediaPlayer.start();
                } else {
                    musicOnOff.setBackground(getDrawable(R.drawable.sound_off));
                    mediaPlayer.pause();
                }
            }
        });


        iv_11 = findViewById(R.id.iv_11);
        iv_12 = findViewById(R.id.iv_12);
        iv_13 = findViewById(R.id.iv_13);
        iv_14 = findViewById(R.id.iv_14);
        iv_15 = findViewById(R.id.iv_15);
        iv_16 = findViewById(R.id.iv_16);
        iv_21 = findViewById(R.id.iv_21);
        iv_22 = findViewById(R.id.iv_22);
        iv_23 = findViewById(R.id.iv_23);
        iv_24 = findViewById(R.id.iv_24);
        iv_25 = findViewById(R.id.iv_25);
        iv_26 = findViewById(R.id.iv_26);
        iv_31 = findViewById(R.id.iv_31);
        iv_32 = findViewById(R.id.iv_32);
        iv_33 = findViewById(R.id.iv_33);
        iv_34 = findViewById(R.id.iv_34);
        iv_35 = findViewById(R.id.iv_35);
        iv_36 = findViewById(R.id.iv_36);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_15.setTag("4");
        iv_16.setTag("5");
        iv_21.setTag("6");
        iv_22.setTag("7");
        iv_23.setTag("8");
        iv_24.setTag("9");
        iv_25.setTag("10");
        iv_26.setTag("11");
        iv_31.setTag("12");
        iv_32.setTag("13");
        iv_33.setTag("14");
        iv_34.setTag("15");
        iv_35.setTag("16");
        iv_36.setTag("17");

        //Load the card images**********************************************************************************************
        frontOfCardsResources();

        // Shuffle the Images_______________________________________________________________________________________________
        Collections.shuffle(Arrays.asList(cardsArray));

        // set onClick to the cards_________________________________________________________________________________________

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_11, theCard);
            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_12, theCard);
            }
        });
        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_13, theCard);
            }
        });
        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_14, theCard);
            }
        });
        iv_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_15, theCard);
            }
        });
        iv_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_16, theCard);
            }
        });
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_21, theCard);
            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_22, theCard);
            }
        });
        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_23, theCard);
            }
        });
        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_24, theCard);
            }
        });
        iv_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_25, theCard);
            }
        });
        iv_26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_26, theCard);
            }
        });
        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_31, theCard);
            }
        });
        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_32, theCard);
            }
        });
        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_33, theCard);
            }
        });
        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_34, theCard);
            }
        });
        iv_35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_35, theCard);
            }
        });
        iv_36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_36, theCard);
            }
        });
    }

    // DoStuff Set the correct image to the ImageView_______________________________________________________________________

    private void doStuff(ImageView iv, int card) {
        if (cardsArray[card] == 101) {
            iv.setImageResource(image101);
        } else if (cardsArray[card] == 102) {
            iv.setImageResource(image102);
        } else if (cardsArray[card] == 103) {
            iv.setImageResource(image103);
        } else if (cardsArray[card] == 104) {
            iv.setImageResource(image104);
        } else if (cardsArray[card] == 105) {
            iv.setImageResource(image105);
        } else if (cardsArray[card] == 106) {
            iv.setImageResource(image106);
        } else if (cardsArray[card] == 107) {
            iv.setImageResource(image107);
        } else if (cardsArray[card] == 108) {
            iv.setImageResource(image108);
        } else if (cardsArray[card] == 109) {
            iv.setImageResource(image109);
        } else if (cardsArray[card] == 201) {
            iv.setImageResource(image201);
        } else if (cardsArray[card] == 202) {
            iv.setImageResource(image202);
        } else if (cardsArray[card] == 203) {
            iv.setImageResource(image203);
        } else if (cardsArray[card] == 204) {
            iv.setImageResource(image204);
        } else if (cardsArray[card] == 205) {
            iv.setImageResource(image205);
        } else if (cardsArray[card] == 206) {
            iv.setImageResource(image206);
        } else if (cardsArray[card] == 207) {
            iv.setImageResource(image207);
        } else if (cardsArray[card] == 208) {
            iv.setImageResource(image208);
        } else if (cardsArray[card] == 209) {
            iv.setImageResource(image209);
        }

        // Check which image is selected & save it to temporary variable____________________________________________________

        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_15.setEnabled(false);
            iv_16.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_25.setEnabled(false);
            iv_26.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);
            iv_35.setEnabled(false);
            iv_36.setEnabled(false);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Check if the selected images are equal_______________________________________________________________
                    calculate();
                }
            }, 700);
        }
    }

    // calculate() Check if the selected images are equal __________________________________________________________________

    private void calculate() {
        // if Images are equal remove them
        if (firstCard == secondCard) {
            if (clickFirst == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 4) {
                iv_15.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 5) {
                iv_16.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 6) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 7) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 8) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 9) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 10) {
                iv_25.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 11) {
                iv_26.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 12) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 13) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 14) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 15) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 16) {
                iv_35.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 17) {
                iv_36.setVisibility(View.INVISIBLE);
            }

            if (clickSecond == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 4) {
                iv_15.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 5) {
                iv_16.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 6) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 7) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 8) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 9) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 10) {
                iv_25.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 11) {
                iv_26.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 12) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 13) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 14) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 15) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 16) {
                iv_35.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 17) {
                iv_36.setVisibility(View.INVISIBLE);
            }
        } else {
            iv_11.setImageResource(R.drawable.shablon);
            iv_12.setImageResource(R.drawable.shablon);
            iv_13.setImageResource(R.drawable.shablon);
            iv_14.setImageResource(R.drawable.shablon);
            iv_15.setImageResource(R.drawable.shablon);
            iv_16.setImageResource(R.drawable.shablon);
            iv_21.setImageResource(R.drawable.shablon);
            iv_22.setImageResource(R.drawable.shablon);
            iv_23.setImageResource(R.drawable.shablon);
            iv_24.setImageResource(R.drawable.shablon);
            iv_25.setImageResource(R.drawable.shablon);
            iv_26.setImageResource(R.drawable.shablon);
            iv_31.setImageResource(R.drawable.shablon);
            iv_32.setImageResource(R.drawable.shablon);
            iv_33.setImageResource(R.drawable.shablon);
            iv_34.setImageResource(R.drawable.shablon);
            iv_35.setImageResource(R.drawable.shablon);
            iv_36.setImageResource(R.drawable.shablon);
        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_15.setEnabled(true);
        iv_16.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_25.setEnabled(true);
        iv_26.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);
        iv_35.setEnabled(true);
        iv_36.setEnabled(true);

        //Check if the Game is Over ________________________________________________________________________________________

        checkEnd();
    }

    // Check if the Game is Over _____ GAME OVER ___________________________________________________________________________

    private void checkEnd() {
        if (iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&
                iv_15.getVisibility() == View.INVISIBLE &&
                iv_16.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&
                iv_25.getVisibility() == View.INVISIBLE &&
                iv_26.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE &&
                iv_35.getVisibility() == View.INVISIBLE &&
                iv_36.getVisibility() == View.INVISIBLE) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GameActivity.this);
            alertDialogBuilder
                    .setMessage("END GAME!\n" + name + "\n WIN")
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    //Load the card Images _________________________________________________________________________________________________

    private void frontOfCardsResources() {
        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image104 = R.drawable.ic_image104;
        image105 = R.drawable.ic_image105;
        image106 = R.drawable.ic_image106;
        image107 = R.drawable.ic_image107;
        image108 = R.drawable.ic_image108;
        image109 = R.drawable.ic_image109;
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;
        image205 = R.drawable.ic_image205;
        image206 = R.drawable.ic_image206;
        image207 = R.drawable.ic_image207;
        image208 = R.drawable.ic_image208;
        image209 = R.drawable.ic_image209;
    }


    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer = MediaPlayer.create(this, R.raw.game);
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}