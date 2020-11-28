/*package com.scale.bat.framework.utility;

import java.io.File;
import java.util.List;
import org.apache.log4j.Logger;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class AwsS3Service {
	private Logger log = Log.getLogger(AwsS3Service.class);
	BasicAWSCredentials awsCred;
	AmazonS3 s3Client;
	Regions clientRegion = Regions.EU_WEST_2;

	public AwsS3Service() {
		awsCred = new BasicAWSCredentials("AKIAV2NOAX5T6QJZKTLQ", "fpek1pIuzeLG/g75w9BJM3EWxTXYlgTzpzWyxgmf");
		s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion)
				.withCredentials(new AWSStaticCredentialsProvider(awsCred)).build();
	}

	
//	 * bucketName - in which we will upload the file File - File from local
//	 * FileNameOnS3 - Name of the file which will be uploaded on S3 Folder - Folder
//	 * in bucket
	 
	public void uploadFileToS3(String bucketName, String file, String fileNameOnS3, String folder) {

		String filePath = System.getProperty("user.dir") + "\\TestData\\" + file;
		log.info("File path : " + filePath);
		log.info("bucketName : " + bucketName);
		log.info("File Name on S3 Folder : " + fileNameOnS3);
		log.info("folder path on S3 : " + folder);

		try {
			 PutObjectRequest request = new PutObjectRequest(bucketName, folder +
			 fileNameOnS3, new File(filePath));
			 s3Client.putObject(request);
			System.out.println(listOfFiles(bucketName, folder));

			log.info("File present - " + checkFileIsPresent(bucketName, fileNameOnS3, folder));
		} catch (AmazonServiceException ex) {
			ex.printStackTrace();
		} catch (SdkClientException e) {
			e.printStackTrace();
		}
	}

	
//	 * Deleting file from S3 bucket Bucket - Bucket name FileName - Name of the file
//	 * to be deleted
	 
	public void deleteFileFromS3(String bucket, String fileName, String folder) {
		try {
			s3Client.deleteObject(bucket, fileName);
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		}
	}

	
//	 * Getting list of files in a bucket
	 
	public List<S3ObjectSummary> listOfFiles(String bucket, String folderKey) {
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(bucket).withPrefix(folderKey);
		return s3Client.listObjects(listObjectsRequest).getObjectSummaries();
	}

	public boolean checkFileIsPresent(String bucket, String fileName, String folder) {
		log.info("Checking if file is present..");
		return s3Client.doesObjectExist(bucket, folder + fileName);
	}

}
*/