package club.csahub.apps.morsecodemultitool

import android.content.Context
import android.hardware.camera2.CameraCharacteristics.FLASH_INFO_AVAILABLE
import android.hardware.camera2.CameraManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val oneTimeUnit = 150.toLong()

    private val waitTimes: HashMap<Char, Long> = hashMapOf(
            '.' to oneTimeUnit,
            '-' to 3 * oneTimeUnit,
            ' ' to 2 * oneTimeUnit,
            '|' to oneTimeUnit
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun translateToMorse(v: View) {
        val dict: HashMap<Char, String> = hashMapOf(
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
                ' ' to "| ",
                '.' to ".-.-.- ",
                ',' to "--..-- ",
                '?' to "..--.. ",
                '\'' to ".----. ",
                '!' to "-.-.-- ",
                '/' to "-..-. ",
                '-' to "-....- ",
                '(' to "-.--.- ",
                ')' to "-.--.- ",
                '"' to ".-..-. ")

        translatedText.text.clear()
        textToTranslate.text.forEach {
            translatedText.text.append(dict[it])
        }

        if (translatedText.text.isBlank()) {
            btnAudio.isEnabled = false
            btnFlashlight.isEnabled = false
            btnVibrate.isEnabled = false
        } else {
            btnAudio.isEnabled = true
            btnFlashlight.isEnabled = true
            btnVibrate.isEnabled = true
        }
    }

    fun replayAsLight(v: View) {        // This assumes that at least one camera has a flash!
        val cam = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        var cameraToUse = "none"

        cam.cameraIdList.forEach {
            if (cam.getCameraCharacteristics(it.toString()).get(FLASH_INFO_AVAILABLE)) {
                cameraToUse = it
            }
        }

        translatedText.text.forEach {
            val theWaitTime = waitTimes[it] as Long

            if (it == ' ' || it == '|') {
                Thread.sleep(theWaitTime)
            } else {
                cam.setTorchMode(cameraToUse, true)
                Thread.sleep(theWaitTime)
                cam.setTorchMode(cameraToUse, false)
            }

            Thread.sleep(oneTimeUnit)
        }

        //TODO("Ensure that flashlight isn't offered if there is no flash on the device")
    }

    fun replayAsVibration(v: View) {

    }

    fun replayAsSound(v: View) {

    }
}