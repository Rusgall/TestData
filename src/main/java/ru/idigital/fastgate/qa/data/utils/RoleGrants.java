package ru.idigital.fastgate.qa.data.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RoleGrants {

    public static Set<String> getDefaultGrants(){
        Set<String> set = new HashSet<>(Arrays.asList("view_abonent",
                "view_agents",
                "view_archive_messages_log",
                "view_black_list",
                "view_black_list_imsi",
                "view_blocked_report",
                "view_common_sms_report",
                "view_confidential_data",
                "view_connection_load_report",
                "view_connections_report",
                "view_def_codes",
                "view_departments",
                "view_distribution_messages",
                "view_distributions",
                "view_distribution_templates",
                "view_error_codes",
                "view_hourly_sms_report",
                "view_info_numbers",
                "view_message_log",
                "view_message_templates",
                "view_message_text",
                "view_monthly_sms_report",
                "view_nondelivery_reasons_report",
                "view_operators_report",
                "view_permanent_distribution_messages",
                "view_permanent_distributions",
                "view_replacement_rules",
                "view_roles",
                "view_routing_connections",
                "view_routing_inbound_channels",
                "view_routing_inbound_rules",
                "view_routing_outbound_rules",
                "view_subscribers_groups",
                "view_templates_report",
                "view_test_messages_log",
                "view_user_activity",
                "view_users"
        ));

        return set;
    }
}
