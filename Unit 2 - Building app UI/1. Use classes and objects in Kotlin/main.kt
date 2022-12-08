//customization
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice internal constructor(val name: String, val category: String) {

    var deviceStatus = "online"
    val deviceType = category

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus =
                when (statusCode) {
                    0 -> "offline"
                    1 -> "online"
                    else -> "unknown"
                }
    }

    var speakVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun turnOn() {
        println("Smart device is turned on.")
        deviceStatus = "on"
    }

    fun turnOff() {
        println("Smart device is turned off.")
        deviceStatus = "off"
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory) {

    // 在 SmartTvDevice 類別中，使用委派類別來定義 speakerVolume 和 channelNumber 屬性
    var speakerVolume by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory) {

    // 在 SmartLightDevice 類別中，使用委派類別來定義 brightnessLevel 屬性
    var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }
}

class SmartHome(val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice) {
    var deviceTurnOnCount = 0
        private set // 僅能讀取無法修改，若直接在前方加上 private 會變成 private field，無法被外部存取
    // 詳細說明：https://ithelp.ithome.com.tw/articles/10204643

    var 

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(initialValue: Int, private val minValue: Int, private val maxValue: Int) :
        ReadWriteProperty<Any?, Int> {
    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val smartHome =
            SmartHome(
                    SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
                    SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
            )

    smartHome.turnOnTv()
    smartHome.turnOnLight()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.increaseLightBrightness()
    println()

    smartHome.turnOffAllDevices()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}.")
}
