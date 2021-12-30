
package covidTestAvailability;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.core.SdkSystemSetting;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lambda.LambdaClient;

/**
 * The module containing all dependencies required by the {@link App}.
 */
public class DependencyFactory {

    private DependencyFactory() {}

    /**
     * @return an instance of LambdaClient
     */
    public static LambdaClient lambdaClient() {
        return LambdaClient.builder()
                       .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                       .region(Region.of(System.getenv(SdkSystemSetting.AWS_REGION.environmentVariable())))
                       .httpClientBuilder(UrlConnectionHttpClient.builder())
                       .build();
    }

    public static SnsClient snsClient() {
        return SnsClient.builder()
            .region(Region.US_WEST_2)
            .build();
    }
}
