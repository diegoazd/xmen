package com.xmen.adn

import com.xmen.adn.resource.MutantResource

import com.yammer.dropwizard.Service
import com.yammer.dropwizard.assets.AssetsBundle
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import com.yammer.dropwizard.db.DatabaseConfiguration
import com.yammer.dropwizard.hibernate.HibernateBundle
import com.yammer.dropwizard.migrations.MigrationsBundle

class FindMutantService extends Service<FindMutantConfiguration> {
    public static void main(String[] args) throws Exception {
        new FindMutantService().run(args)
    }

    HibernateBundle<FindMutantConfiguration> hibernateBundle =
        new HibernateBundle<FindMutantConfiguration>([]) {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(FindMutantConfiguration configuration) {
                return configuration.databaseConfiguration
            }
        }

    MigrationsBundle<FindMutantConfiguration> migrationsBundle =
        new MigrationsBundle<FindMutantConfiguration>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(FindMutantConfiguration configuration) {
                return configuration.databaseConfiguration
            }
        }

    AssetsBundle assetsBundle = new AssetsBundle()

    @Override
    public void initialize(Bootstrap<FindMutantConfiguration> bootstrap) {
        bootstrap.with {
            name = 'FindMutant'
            addBundle migrationsBundle
            addBundle hibernateBundle
        }
    }

    @Override
    public void run(FindMutantConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
      environment.addResource(new MutantResource())
    }
}
