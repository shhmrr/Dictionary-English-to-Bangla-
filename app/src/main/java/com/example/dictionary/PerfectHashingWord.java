package com.example.dictionary;


import java.io.File;

public class PerfectHashingWord {
    private String word;
    private long unique_key;
    private int m = 125;
    private int[] arr_first_hash = new int[m];
    private int[] arr_second_hash_0,arr_second_hash_2,arr_second_hash_3,arr_second_hash_4,arr_second_hash_5,arr_second_hash_6,arr_second_hash_7;
    private int[] arr_second_hash_8,arr_second_hash_10,arr_second_hash_11,arr_second_hash_13,arr_second_hash_15,arr_second_hash_17,arr_second_hash_18;
    private int[] arr_second_hash_19,arr_second_hash_21,arr_second_hash_22,arr_second_hash_25,arr_second_hash_27,arr_second_hash_28;
    private int[] arr_second_hash_29,arr_second_hash_30,arr_second_hash_31,arr_second_hash_32,arr_second_hash_34,arr_second_hash_35,arr_second_hash_36;
    private int[] arr_second_hash_37,arr_second_hash_39,arr_second_hash_40,arr_second_hash_43,arr_second_hash_45,arr_second_hash_46,arr_second_hash_47;
    private int[] arr_second_hash_48,arr_second_hash_50,arr_second_hash_53,arr_second_hash_54,arr_second_hash_55,arr_second_hash_56,arr_second_hash_58;
    private int[] arr_second_hash_60,arr_second_hash_62,arr_second_hash_65,arr_second_hash_66,arr_second_hash_67,arr_second_hash_69,arr_second_hash_73;
    private int[] arr_second_hash_74,arr_second_hash_75,arr_second_hash_76,arr_second_hash_78,arr_second_hash_79,arr_second_hash_80,arr_second_hash_81;
    private int[] arr_second_hash_82,arr_second_hash_85,arr_second_hash_87,arr_second_hash_91,arr_second_hash_92,arr_second_hash_97,arr_second_hash_98;
    private int[] arr_second_hash_100,arr_second_hash_102,arr_second_hash_105,arr_second_hash_106,arr_second_hash_107,arr_second_hash_108;
    private int[] arr_second_hash_109,arr_second_hash_110,arr_second_hash_113,arr_second_hash_115,arr_second_hash_117,arr_second_hash_119;
    private int[] arr_second_hash_120,arr_second_hash_121,arr_second_hash_123,arr_second_hash_124;

    private int fileIdentifier = 0;

    private static void main(String args[]) {

    }

    //Apostrophe "'" : 27
    //Hyphen "-" : 28
    //Dot "." : 29

    // Generates unique key for alphabetical strings.
    private void generateUniqueKey(String word) {
        unique_key = 0;
        int a = -1;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i)>='a' && word.charAt(i)<='z') {
                 a = word.charAt(i) - 96;
            }
            else if(word.charAt(i) == '\'')
            {
                a = 27;
            }
            else if(word.charAt(i) == '-')
            {
                a = 28;
            }
            else if(word.charAt(i) == '.')
            {
                a = 29;
            }
            else
            {
                fileIdentifier = -2; // invalid character
                break;
            }
            System.out.println("The value a is: " + a);
            unique_key = unique_key * 29 + a;
            System.out.println("The intermediate unique value is: " + unique_key);
            //System.out.println(a);
        }
        System.out.println("*** The key for " + word + " is: " + unique_key + "  ***");
        if(fileIdentifier!= -2){
        firstLayerHash(unique_key);}
    }

    // Assigns Number of keys inserted in ith index of arr_first_hash.
    private void arrFirstHash()
    {
        arr_first_hash[2] = 1;arr_first_hash[3] = 2;arr_first_hash[4] = 2;arr_first_hash[5] = 5;arr_first_hash[6] = 1;arr_first_hash[7] = 1;arr_first_hash[8] = 2;
        arr_first_hash[10] = 2;arr_first_hash[11] = 3;arr_first_hash[13] = 1;arr_first_hash[15] = 2;arr_first_hash[17] = 2;arr_first_hash[18] = 1;arr_first_hash[19] = 1;
        arr_first_hash[21] = 3;arr_first_hash[22] = 1;arr_first_hash[25] = 1;arr_first_hash[27] = 1;arr_first_hash[28] = 1;arr_first_hash[29] = 1;arr_first_hash[30] = 1;
        arr_first_hash[31] = 4;arr_first_hash[32] = 2;arr_first_hash[34] = 1;arr_first_hash[35] = 2;arr_first_hash[36] = 1;arr_first_hash[37] = 1;arr_first_hash[39] = 1;
        arr_first_hash[40] = 1;arr_first_hash[43] = 2;arr_first_hash[45] = 2;arr_first_hash[46] = 4;arr_first_hash[47] = 1;arr_first_hash[48] = 2;arr_first_hash[50] = 2;
        arr_first_hash[53] = 1;arr_first_hash[54] = 2;arr_first_hash[55] = 1;arr_first_hash[56] = 1;arr_first_hash[58] = 1;arr_first_hash[60] = 2;arr_first_hash[62] = 2;
        arr_first_hash[65] = 1;arr_first_hash[66] = 2;arr_first_hash[67] = 1;arr_first_hash[69] = 2;arr_first_hash[73] = 1;arr_first_hash[74] = 1;arr_first_hash[75] = 1;
        arr_first_hash[76] = 1;arr_first_hash[78] = 1;arr_first_hash[79] = 1;arr_first_hash[80] = 1;arr_first_hash[81] = 1;arr_first_hash[82] = 1;arr_first_hash[85] = 1;
        arr_first_hash[87] = 1;arr_first_hash[91] = 3;arr_first_hash[92] = 3;arr_first_hash[97] = 1;arr_first_hash[98] = 2;arr_first_hash[100] = 4;arr_first_hash[102] = 1;
        arr_first_hash[105] = 1;arr_first_hash[106] = 3;arr_first_hash[107] = 4;arr_first_hash[108] = 1;arr_first_hash[109] = 1;arr_first_hash[110] = 2;arr_first_hash[113] = 3;
        arr_first_hash[115] = 1;arr_first_hash[117] = 1;arr_first_hash[119] = 1;arr_first_hash[120] = 1;arr_first_hash[121] = 1;arr_first_hash[123] = 1;arr_first_hash[124] = 2;

    }

    // Assigning File values to the second hashes
    private void arrSecondHash(int h_of_k, int word_count_per_index)
    {
        int second_index_size = 1;
        // word count 1
        if(h_of_k == 2)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_2 = new int[second_index_size];
            arr_second_hash_2[0] = R.raw.a_2_0;



        }
        // word count 2
        else if(h_of_k == 3)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_3 = new int[second_index_size];
            arr_second_hash_3[2] = R.raw.a_3_2;
            arr_second_hash_3[0] = R.raw.a_3_0;

        }
        // word count 2
        else if(h_of_k == 4)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_4 = new int[second_index_size];
            arr_second_hash_4[1] = R.raw.a_4_1;
            arr_second_hash_4[3] = R.raw.a_4_3;

        }
        // word count 5
        else if(h_of_k == 5)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_5 = new int[second_index_size];
            arr_second_hash_5[12] = R.raw.a_5_12;
            arr_second_hash_5[5] = R.raw.a_5_5;
            arr_second_hash_5[11] = R.raw.a_5_11;
            arr_second_hash_5[2] = R.raw.a_5_2;
            arr_second_hash_5[16] = R.raw.a_5_16;

        }
        // word count 1
        else if(h_of_k == 6)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_6 = new int[second_index_size];
            arr_second_hash_6[0] = R.raw.a_6_0;

        }
        // word count 1
        else if(h_of_k == 7)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_7 = new int[second_index_size];
            arr_second_hash_7[0] = R.raw.a_7_0;

        }
        // word count 2
        else if(h_of_k == 8)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_8 = new int[second_index_size];
            arr_second_hash_8[1] = R.raw.a_8_1;
            arr_second_hash_8[3] = R.raw.a_8_3;

        }
        // word count 2
        else if(h_of_k == 10)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_10 = new int[second_index_size];
            arr_second_hash_10[3] = R.raw.a_10_3;
            arr_second_hash_10[0] = R.raw.a_10_0;

        }
        // word count 3
        else if(h_of_k == 11)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_11 = new int[second_index_size];
            arr_second_hash_11[8] = R.raw.a_11_8;
            arr_second_hash_11[2] = R.raw.a_11_2;
            arr_second_hash_11[5] = R.raw.a_11_5;

        }
        // word count 1
        else if(h_of_k == 13)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_13 = new int[second_index_size];
            arr_second_hash_13[0] = R.raw.a_13_0;

        }
        // word count 2
        else if(h_of_k == 15)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_15 = new int[second_index_size];
            arr_second_hash_15[0] = R.raw.a_15_0;
            arr_second_hash_15[3] = R.raw.a_15_3;

        }
        // word count 2
        else if(h_of_k == 17)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_17 = new int[second_index_size];
            arr_second_hash_17[0] = R.raw.a_17_0;
            arr_second_hash_17[2] = R.raw.a_17_2;

        }
        // word count 1
        else if(h_of_k == 18)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_18 = new int[second_index_size];
            arr_second_hash_18[0] = R.raw.a_18_0;

        }
        // word count 1
        else if(h_of_k == 19)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_19 = new int[second_index_size];
            arr_second_hash_19[0] = R.raw.a_19_0;

        }
        // word count 3
        else if(h_of_k == 21)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_21 = new int[second_index_size];
            arr_second_hash_21[3] = R.raw.a_21_3;
            arr_second_hash_21[5] = R.raw.a_21_5;
            arr_second_hash_21[1] = R.raw.a_21_1;

        }
        // word count 1
        else if(h_of_k == 22)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_22 = new int[second_index_size];
            arr_second_hash_22[0] = R.raw.a_22_0;

        }
        // word count 1
        else if(h_of_k == 25)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_25 = new int[second_index_size];
            arr_second_hash_25[0] = R.raw.a_25_0;

        }// word count 1
        else if(h_of_k == 27)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_27 = new int[second_index_size];
            arr_second_hash_27[0] = R.raw.a_27_0;

        }
        // word count 1
        else if(h_of_k == 28)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_28 = new int[second_index_size];
            arr_second_hash_28[0] = R.raw.a_28_0;

        }
        // word count 1
        else if(h_of_k == 29)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_29 = new int[second_index_size];
            arr_second_hash_29[0] = R.raw.a_29_0;

        }
        // word count 1
        else if(h_of_k == 30)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_30 = new int[second_index_size];
            arr_second_hash_30[0] = R.raw.a_30_0;

        }
        // word count 4
        else if(h_of_k == 31)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_31 = new int[second_index_size];
            arr_second_hash_31[11] = R.raw.a_31_11;
            arr_second_hash_31[14] = R.raw.a_31_14;
            arr_second_hash_31[12] = R.raw.a_31_12;
            arr_second_hash_31[3] = R.raw.a_31_3;

        }
        // word count 2
        else if(h_of_k == 32)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_32 = new int[second_index_size];

            arr_second_hash_32[2] = R.raw.a_32_2;
            arr_second_hash_32[1] = R.raw.a_32_1;

        }
        // word count 1
        else if(h_of_k == 34)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_34 = new int[second_index_size];
            arr_second_hash_34[0] = R.raw.a_34_0;

        }
        // word count 2
        else if(h_of_k == 35)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_35 = new int[second_index_size];
            arr_second_hash_35[2] = R.raw.a_35_2;
            arr_second_hash_35[3] = R.raw.a_35_3;

        }
        // word count 1
        else if(h_of_k == 36)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_36 = new int[second_index_size];
            arr_second_hash_36[0] = R.raw.a_36_0;

        }
        // word count 1
        else if(h_of_k == 37)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_37 = new int[second_index_size];
            arr_second_hash_37[0] = R.raw.a_37_0;

        }
        // word count 1
        else if(h_of_k == 39)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_39 = new int[second_index_size];
            arr_second_hash_39[0] = R.raw.a_39_0;

        }
        // word count 1
        else if(h_of_k == 40)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_40 = new int[second_index_size];
            arr_second_hash_40[0] = R.raw.a_40_0;

        }
        // word count 2
        else if(h_of_k == 43)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_43 = new int[second_index_size];
            arr_second_hash_43[1] = R.raw.a_43_1;
            arr_second_hash_43[0] = R.raw.a_43_0;

        }
        // word count 2
        else if(h_of_k == 45)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_45 = new int[second_index_size];
            arr_second_hash_45[2] = R.raw.a_45_2;
            arr_second_hash_45[0] = R.raw.a_45_0;

        }
        // word count 4
        else if(h_of_k == 46)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_46 = new int[second_index_size];
            arr_second_hash_46[13] = R.raw.a_46_13;
            arr_second_hash_46[7] = R.raw.a_46_7;
            arr_second_hash_46[4] = R.raw.a_46_4;
            arr_second_hash_46[9] = R.raw.a_46_9;

        }
        // word count 1
        else if(h_of_k == 47)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_47 = new int[second_index_size];
            arr_second_hash_47[0] = R.raw.a_47_0;

        }
        // word count 2
        else if(h_of_k == 48)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_48 = new int[second_index_size];
            arr_second_hash_48[1] = R.raw.a_48_1;
            arr_second_hash_48[0] = R.raw.a_48_0;

        }
        // word count 2
        else if(h_of_k == 50)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_50 = new int[second_index_size];
            arr_second_hash_50[2] = R.raw.a_50_2;
            arr_second_hash_50[0] = R.raw.a_50_0;

        }
        // word count 1
        else if(h_of_k == 53)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_53 = new int[second_index_size];
            arr_second_hash_53[0] = R.raw.a_53_0;

        }
        // word count 2
        else if(h_of_k == 54)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_54 = new int[second_index_size];
            arr_second_hash_54[2] = R.raw.a_54_2;
            arr_second_hash_54[0] = R.raw.a_54_0;

        }
        // word count 1
        else if(h_of_k == 55)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_55 = new int[second_index_size];
            arr_second_hash_55[0] = R.raw.a_55_0;

        }
        // word count 1
        else if(h_of_k == 56)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_56 = new int[second_index_size];
            arr_second_hash_56[0] = R.raw.a_56_0;

        }
        // word count 1
        else if(h_of_k == 58)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_58 = new int[second_index_size];
            arr_second_hash_58[0] = R.raw.a_58_0;

        }
        // word count 2
        else if(h_of_k == 60)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_60 = new int[second_index_size];
            arr_second_hash_60[3] = R.raw.a_60_3;
            arr_second_hash_60[0] = R.raw.a_60_0;

        }
        // word count 2
        else if(h_of_k == 62)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_62 = new int[second_index_size];
            arr_second_hash_62[0] = R.raw.a_62_0;
            arr_second_hash_62[2] = R.raw.a_62_2;

        }
        // word count 1
        else if(h_of_k == 65)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_65 = new int[second_index_size];
            arr_second_hash_65[0] = R.raw.a_65_0;

        }
        // word count 2
        else if(h_of_k == 66)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_66 = new int[second_index_size];
            arr_second_hash_66[1] = R.raw.a_66_1;
            arr_second_hash_66[2] = R.raw.a_66_2;

        }
        // word count 1
        else if(h_of_k == 67)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_67 = new int[second_index_size];
            arr_second_hash_67[0] = R.raw.a_67_0;

        }
        // word count 2
        else if(h_of_k == 69)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_69 = new int[second_index_size];
            arr_second_hash_69[1] = R.raw.a_69_1;
            arr_second_hash_69[0] = R.raw.a_69_0;

        }
        // word count 1
        else if(h_of_k == 73)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_73 = new int[second_index_size];
            arr_second_hash_73[0] = R.raw.a_73_0;

        }
        // word count 1
        else if(h_of_k == 74)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_74 = new int[second_index_size];
            arr_second_hash_74[0] = R.raw.a_74_0;

        }
        // word count 1
        else if(h_of_k == 75)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_75 = new int[second_index_size];
            arr_second_hash_75[0] = R.raw.a_75_0;

        }
        // word count 1
        else if(h_of_k == 76)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_76 = new int[second_index_size];
            arr_second_hash_76[0] = R.raw.a_76_0;

        }
        // word count 1
        else if(h_of_k == 78)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_78 = new int[second_index_size];
            arr_second_hash_78[0] = R.raw.a_78_0;

        }
        // word count 1
        else if(h_of_k == 79)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_79 = new int[second_index_size];
            arr_second_hash_79[0] = R.raw.a_79_0;

        }
        // word count 1
        else if(h_of_k == 80)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_80 = new int[second_index_size];
            arr_second_hash_80[0] = R.raw.a_80_0;

        }
        // word count 1
        else if(h_of_k == 81)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_81 = new int[second_index_size];
            arr_second_hash_81[0] = R.raw.a_81_0;

        }
        // word count 1
        else if(h_of_k == 82)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_82 = new int[second_index_size];
            arr_second_hash_82[0] = R.raw.a_82_0;

        }
        // word count 1
        else if(h_of_k == 85)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_85 = new int[second_index_size];
            arr_second_hash_85[0] = R.raw.a_85_0;

        }
        // word count 1
        else if(h_of_k == 87)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_87 = new int[second_index_size];
            arr_second_hash_87[0] = R.raw.a_87_0;

        }
        // word count 3
        else if(h_of_k == 91)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_91 = new int[second_index_size];
            arr_second_hash_91[3] = R.raw.a_91_3;
            arr_second_hash_91[1] = R.raw.a_91_1;
            arr_second_hash_91[4] = R.raw.a_91_4;

        }
        // word count 3
        else if(h_of_k == 92)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_92 = new int[second_index_size];
            arr_second_hash_92[0] = R.raw.a_92_0;
            arr_second_hash_92[7] = R.raw.a_92_7;
            arr_second_hash_92[4] = R.raw.a_92_4;

        }
        // word count 1
        else if(h_of_k == 97)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_97 = new int[second_index_size];
            arr_second_hash_97[0] = R.raw.a_97_0;

        }
        // word count 2
        else if(h_of_k == 98)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_98 = new int[second_index_size];
            arr_second_hash_98[1] = R.raw.a_98_1;
            arr_second_hash_98[0] = R.raw.a_98_0;

        }
        // word count 4
        else if(h_of_k == 100)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_100 = new int[second_index_size];
            arr_second_hash_100[13] = R.raw.a_100_13;
            arr_second_hash_100[5] = R.raw.a_100_5;
            arr_second_hash_100[9] = R.raw.a_100_9;
            arr_second_hash_100[3] = R.raw.a_100_3;

        }
        // word count 1
        else if(h_of_k == 102)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_102 = new int[second_index_size];
            arr_second_hash_102[0] = R.raw.a_102_0;

        }
        // word count 1
        else if(h_of_k == 105)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_105 = new int[second_index_size];
            arr_second_hash_105[0] = R.raw.a_105_0;

        }
        // word count 3
        else if(h_of_k == 106)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_106 = new int[second_index_size];
            arr_second_hash_106[2] = R.raw.a_106_2;
            arr_second_hash_106[8] = R.raw.a_106_8;
            arr_second_hash_106[5] = R.raw.a_106_5;

        }
        // word count 4
        else if(h_of_k == 107)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_107 = new int[second_index_size];
            arr_second_hash_107[2] = R.raw.a_107_2;
            arr_second_hash_107[12] = R.raw.a_107_12;
            arr_second_hash_107[8] = R.raw.a_107_8;
            arr_second_hash_107[5] = R.raw.a_107_5;

        }
        // word count 1
        else if(h_of_k == 108)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_108 = new int[second_index_size];
            arr_second_hash_108[0] = R.raw.a_108_0;

        }
        // word count 1
        else if(h_of_k == 109)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_109 = new int[second_index_size];
            arr_second_hash_109[0] = R.raw.a_109_0;

        }
        // word count 2
        else if(h_of_k == 110)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_110 = new int[second_index_size];
            arr_second_hash_110[1] = R.raw.a_110_1;
            arr_second_hash_110[3] = R.raw.a_110_3;

        }
        // word count 3
        else if(h_of_k == 113)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_113 = new int[second_index_size];
            arr_second_hash_113[0] = R.raw.a_113_0;
            arr_second_hash_113[4] = R.raw.a_113_4;
            arr_second_hash_113[2] = R.raw.a_113_2;

        }
        // word count 1
        else if(h_of_k == 115)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_115 = new int[second_index_size];
            arr_second_hash_115[0] = R.raw.a_115_0;

        }
        // word count 1
        else if(h_of_k == 117)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_117 = new int[second_index_size];
            arr_second_hash_117[0] = R.raw.a_117_0;

        }
        // word count 1
        else if(h_of_k == 119)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_119 = new int[second_index_size];
            arr_second_hash_119[0] = R.raw.a_119_0;

        }
        // word count 1
        else if(h_of_k == 120)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_120 = new int[second_index_size];
            arr_second_hash_120[0] = R.raw.a_120_0;

        }
        // word count 1
        else if(h_of_k == 121)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_121 = new int[second_index_size];
            arr_second_hash_121[0] = R.raw.a_121_0;

        }
        // word count 1
        else if(h_of_k == 123)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_123 = new int[second_index_size];
            arr_second_hash_123[0] = R.raw.a_123_0;

        }
        // word count 2
        else if(h_of_k == 124)
        {
            second_index_size = (int) Math.pow(word_count_per_index,2);
            arr_second_hash_124 = new int[second_index_size];
            arr_second_hash_124[2] = R.raw.a_124_2;
            arr_second_hash_124[3] = R.raw.a_124_3;

        }
        else
        {
            fileIdentifier = -3; // word not added try another word
        }





    }


    private int hashFn1(int a, int b, long k, int m)
    {
        return (int)((a*k + b)%m);
    }

    private int hashFn2(int a, int b, long k, int m)
    {
        return (int)((a*k + b)%m);
    }



    // Road to Second Hash
    private void firstLayerHash(long unique_key)
    {
        int h_of_k = (int)(unique_key%m);
        arrFirstHash();

        int word_count_per_index = arr_first_hash[h_of_k];

        System.out.println(word + " hashed to: " + h_of_k + " index of first array.");
        System.out.println(h_of_k + " index has: " + word_count_per_index + " values.");

        arrSecondHash(h_of_k,word_count_per_index);

        int m2 = (int)Math.pow(word_count_per_index,2);

        int h2_of_k = 0;
        if(h_of_k == 2)
        { // ear
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_2[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 3)
        { // marriage urban
            int a1 = 1333779793, b1 = 23;
            int a2 = 8, b2 = 7;
            m2 = m2 -1;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(a2,b2,unique_key,m2))%m2;
            fileIdentifier = arr_second_hash_3[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 4)
        { // jail obese
            int a1 = 1, b1 = 17;
            int a2 = 8, b2 = 7;


            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_4[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 5)
        { // jewel mishap paint sail seen
            int a1 = 77777777, b1 = 124;
            int a2 = 6, b2 = 7;
            m2 = m2 -1;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(a2,b2,unique_key,m2))%m2;
            fileIdentifier = arr_second_hash_5[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 6)
        { // file
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_6[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 7)
        { // margin
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_7[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 8)
        { // index kind
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_8[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 10)
        { // gun image
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_10[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 11)
        { // dwell know nuclear
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_11[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 13)
        { // header
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_13[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 15)
        { // busy zest
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_15[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 17)
        { // face fellow
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_17[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 18)
        { // include
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_18[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 19)
        { // made
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_19[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 21)
        { // angel labor quote
            int a1 = 77784, b1 = 77;
            int a2 = 42, b2 = 80;
            m2 = m2 - 1;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(a2,b2,unique_key,m2))%m2;
            fileIdentifier = arr_second_hash_21[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 22)
        { // thumb
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_22[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 25)
        { // oaf
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_25[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 27)
        { // value
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_27[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 28)
        { // nut
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_28[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 29)
        { // umbrella
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_29[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 30)
        { // edible
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_30[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 31)
        { // cemetery it pencil rural
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_31[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 32)
        { // dew tear
            int a1 = 777333, b1 = 77;
            int a2 = 80, b2 = 24;
            m2 = m2 - 1;



            h2_of_k = (hashFn1(a1,b1,unique_key - 1,m2) + hashFn2(a2,b2,unique_key - 1,m2))%m2;
            fileIdentifier = arr_second_hash_32[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 34)
        { // abandon
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_34[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 35)
        { // albeit items
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_35[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 36)
        { // guess
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_36[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 37)
        { // xenon
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_37[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 39)
        { // frog
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_39[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 40)
        { // yell
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_40[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 43)
        { // differ whole
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_43[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 45)
        { // van view
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_45[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 46)
        { // gender key kitchen tiger
            int a1 = 999, b1 = 2;
            int a2 = 860, b2 = 2;
            m2 = m2 - 2;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(a2,b2,unique_key,m2))%m2;
            fileIdentifier = arr_second_hash_46[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 47)
        { // nurse
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_47[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 48)
        { // landlord panic
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_48[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 50)
        { // hidden language
            int a1 = 1234590777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2 -1) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_50[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 53)
        { // devout
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_53[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 54)
        { // bridge toneless
            int a1 = 123433778, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2 -1) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_54[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 55)
        { // quit
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_55[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 56)
        { // upgrade
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_56[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 58)
        { // kite
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_58[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 60)
        { // queen race
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_60[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 62)
        { // cafe eclipse
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_62[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 65)
        { // business
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_65[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 66)
        { // buy of
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_66[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 67)
        { // water
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_67[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 69)
        { // jump silk
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_69[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 73)
        { // warm
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_73[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 74)
        { // yolk
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_74[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 75)
        { // chance
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_75[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 76)
        { // airborne
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_76[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 78)
        { // x-ray
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_78[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 79)
        { // rabbit
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_79[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 80)
        { // economics
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_80[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 81)
        { // zebra
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_81[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 82)
        { // vs.
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_82[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 85)
        { // grain
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_85[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 87)
        { // radio
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_87[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 91)
        { // cage mad tea
            int a1 = 77553377, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_91[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 92)
        { // angle null yard
            int a1 = 77553377, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_92[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 97)
        { // weight
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_97[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 98)
        { // hobby uncle
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_98[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 100)
        { // burn habit quite salt
            int a1 = 1234234, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2-2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_100[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 102)
        { // year
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_102[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 105)
        { // full
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_105[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 106)
        { // petition you zero
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_106[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 107)
        { // east lack large now
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_107[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 108)
        { // search
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_108[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 109)
        { // outlawed
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_109[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 110)
        { // costume jolly
            int a1 = 77553377, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_110[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 113)
        { // hand oasis quick
            int a1 = 716457, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2-1) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_113[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 115)
        { // read
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_115[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 117)
        { // village
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_117[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 119)
        { // justice
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_119[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 120)
        { // gather
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_120[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 121)
        { // wage
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_121[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 123)
        { // dream
            int a1 = 1, b1 = 0;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_123[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else if(h_of_k == 124)
        { // pond under
            int a1 = 777, b1 = 77;

            h2_of_k = (hashFn1(a1,b1,unique_key,m2) + hashFn2(0,0,0,m2))%m2;
            fileIdentifier = arr_second_hash_124[h2_of_k];
            System.out.println("Second hash value is: " + h2_of_k);
            System.out.println(fileIdentifier);
        }
        else
        {
            fileIdentifier = -3; // Word not added Try another word.

        }

    }

    // Passes Word.
    public String getWord()
    {
        return word;
    }

    // Passes Word.
    public int getFileIdentifier()
    {
        return fileIdentifier;
    }

    //constructor
    public PerfectHashingWord(String word)
    {
        this.word = word;
        this.word = this.word.toLowerCase();
        System.out.println("The word is: " + word);
        generateUniqueKey(this.word);

    }


}

