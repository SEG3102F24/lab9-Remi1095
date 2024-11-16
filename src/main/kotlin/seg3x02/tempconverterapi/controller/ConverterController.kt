package seg3x02.tempconverterapi.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("temperature-converter")
class ConverterController {

    private val logger = LoggerFactory.getLogger(ConverterController::class.java)

    @GetMapping("/celsius-fahrenheit/{celsius}")
    fun getFahrenheit(@PathVariable celsius: Double): Double {
        System.out.println("Converting $celsius Celsius to Fahrenheit");
        logger.info("Converting $celsius Celsius to Fahrenheit")
        return ((celsius * 9) / 5) + 32
    }

    @GetMapping("/fahrenheit-celsius/{fahrenheit}")
    fun getCelsius(@PathVariable fahrenheit: Double): Double {
        System.out.println("Converting $fahrenheit Celsius to Fahrenheit");
        logger.info("Converting $fahrenheit Fahrenheit to Celsius")
        return ((fahrenheit - 32) * 5) / 9
    }
}
