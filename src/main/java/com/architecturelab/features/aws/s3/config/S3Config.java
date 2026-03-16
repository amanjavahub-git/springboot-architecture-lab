package com.architecturelab.features.aws.s3.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

   /* @Value("${aws.access.key}")
    private String awsAccessKey;

    @Value("${aws.secret.key}")
    private String awsSecretKey;*/

    @Value("${aws.region}")
    private String awsRegion;


  /**   IAM Policy like AmazonS3FullAccess nhi lga ho user p to awsAccessKey or awsSecretkey use karna hoga. **/
  /*
  @Bean
    public AmazonS3 amazonS3() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        return AmazonS3ClientBuilder.standard()
                .withRegion(awsRegion) // Change to your region
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }*/

  /** Mainey yaha user p IAM AmazonS3FullAccess policy lgaya hai ab yaha awsAccessKey or awsSecretkey use nhi karna hoga
     agar fir b koi awsAccessKey or awsSecretKey use kartey hai to hardcoded mat karo usko AWS CLI k through set kar do fir application.yaml p hard cod karney ki jarurat nhi
      Step hai :
       1) Install AWS CLI to your Local System
       2) command prompt p --> aws configure
        fir wha sey awsAccessKey , awsSecretkey , region , output format puchega command prompt p wo aap dey do AWS sey or aap fir AWSUserCredentials use kar paogey.

     Note : But eski jarurat nhi hai.
     Most Important - Agar Aapney IAM Policy(AmazonS3FullAccess) lga di hai AWS Console k USER p to awsAccessKey , awsSecretKey, region ki jarurat nhi hoti hai jaisa nichey k code mey hai
     **/

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder.standard()
                .withRegion(awsRegion) // Change to your region
                .build();
    }
}