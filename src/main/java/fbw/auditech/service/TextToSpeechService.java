package fbw.auditech.service;

import com.google.cloud.texttospeech.*;
import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import fbw.auditech.model.AudioPalavraPair;
import fbw.auditech.model.Palavras;
import fbw.auditech.config.AppConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TextToSpeechService {

    @Autowired
    private Random random;

    @Autowired
    private Palavras palavras;

    private final Environment env;

    @Autowired
    public TextToSpeechService(Environment env) {
        this.env = env;
    }

    public List<AudioPalavraPair> convertTextToSpeech() {
        String keyPath = env.getProperty("GOOGLE_APPLICATION_CREDENTIALS");

        if (keyPath == null) {
            throw new RuntimeException("A chave não foi encontrada encontrada.");
        }

        int listaAleatoria = random.nextInt(4);

        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
            List<String> palavrasList;
            switch (listaAleatoria) {
                case 0:
                    palavrasList = palavras.getPrimeiroNivel();
                    break;
                case 1:
                    palavrasList = palavras.getSegundoNivel();
                    break;
                case 2:
                    palavrasList = palavras.getTerceiroNivel();
                    break;
                case 3:
                    palavrasList = palavras.getQuartoNivel();
                    break;
                default:
                    palavrasList = palavras.getPrimeiroNivel();
                    break;
            }

            List<AudioPalavraPair> audioPalavraPairs = new ArrayList<>();

            for (String palavra : palavrasList) {
                SynthesisInput input = SynthesisInput.newBuilder().setText(palavra).build();
                VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
                        .setLanguageCode("en-US")
                        .setSsmlGender(SsmlVoiceGender.NEUTRAL)
                        .build();
                AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.LINEAR16).build();

                SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

                byte[] audioData = response.getAudioContent().toByteArray();
                AudioPalavraPair pair = new AudioPalavraPair(audioData, palavra);
                audioPalavraPairs.add(pair);
            }

            return audioPalavraPairs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
