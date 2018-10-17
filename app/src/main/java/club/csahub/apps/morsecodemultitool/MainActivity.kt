package club.csahub.apps.morsecodemultitool

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun translateToMorse(v: View) {
        var dict: HashMap<Char, String> = hashMapOf(
                'A' to ".- ",
                'B' to "-... ",
                'C' to "-.-. ",
                'D' to "-.. ",
                'E' to ". ",
                'F' to "..-. ",
                'G' to "--. ",
                'H' to ".... ",
                'I' to ".. ",
                'J' to ".--- ",
                'K' to "-.- ",
                'L' to ".-.. ",
                'M' to "-- ",
                'N' to "-. ",
                'O' to "--- ",
                'P' to ".--. ",
                'Q' to "--.- ",
                'R' to ".-. ",
                'S' to "... ",
                'T' to "- ",
                'U' to "..- ",
                'V' to "...- ",
                'W' to ".-- ",
                'X' to "-..- ",
                'Y' to "-.-- ",
                'Z' to "--.. ",
                'a' to ".- ",
                'b' to "-... ",
                'c' to "-.-. ",
                'd' to "-.. ",
                'e' to ". ",
                'f' to "..-. ",
                'g' to "--. ",
                'h' to ".... ",
                'i' to ".. ",
                'j' to ".--- ",
                'k' to "-.- ",
                'l' to ".-.. ",
                'm' to "-- ",
                'n' to "-. ",
                'o' to "--- ",
                'p' to ".--. ",
                'q' to "--.- ",
                'r' to ".-. ",
                's' to "... ",
                't' to "- ",
                'u' to "..- ",
                'v' to "...- ",
                'w' to ".-- ",
                'x' to "-..- ",
                'y' to "-.-- ",
                'z' to "--.. ",
                '1' to ".---- ",
                '2' to "..--- ",
                '3' to "...-- ",
                '4' to "....- ",
                '5' to "..... ",
                '6' to "-.... ",
                '7' to "--... ",
                '8' to "---.. ",
                '9' to "----. ",
                '0' to "----- ",
                ' ' to "   ",
                '.' to "   .-.-.- ",
                ',' to "--..-- ",
                '?' to "..--.. ",
                '\'' to ".----. ",
                '!' to "-.-.-- ",
                '/' to "-..-. ",
                '-' to "-....- ",
                '(' to "-.--.- ",
                ')' to "-.--.- ",
                '"' to ".-..-. ")

        val toTranslate = findViewById<EditText>(R.id.textToTranslate)
        val translated = findViewById<EditText>(R.id.translatedText)

        translated.text.clear()
        toTranslate.text.forEach {
            translated.text.append(dict[it])
        }
    }
}