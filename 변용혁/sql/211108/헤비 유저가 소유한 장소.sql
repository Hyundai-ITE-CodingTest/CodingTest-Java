SELECT ID, NAME, HOST_ID FROM places
    where host_id in (SELECT host_id from places
                        group by host_id
                        having count(*) >= 2)
    order by id
