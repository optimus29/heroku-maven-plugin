package com.heroku.sdk.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.io.File;
import java.util.ArrayList;

/**
 * Deploys a war file to Heroku
 *
 * @goal deploy-war-slug
 * @execute phase="package"
 */
public class DeployWarSlugMojo extends HerokuWarMojo {

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    try {
      (prepareWarFile()).deploySlug(
          new ArrayList<File>(getIncludes()), getConfigVars(), jdkUrl == null ? jdkVersion : jdkUrl, stack, slugFilename
      );
    } catch (Exception e) {
      throw new MojoFailureException("Failed to deploy application", e);
    }
  }
}
